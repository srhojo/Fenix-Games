var components = [{
        id: 1,
        value: 'Games',
        uri: ''
    },
    {
        id: 2,
        value: 'Players',
        uri: ''
    }
];

var vmNavbar = new Vue({
    el: '#mainNavbars',
    data: {
        components: components
    }
});

var vmGamesPage = new Vue({
    el: '#gamesPage',
    data: {
        game: {
            id: null,
            name: "",
            description: ""
        },
        gamesList: [],
        gamesListErrored: false,
        gamesListLoading: true
    },
    methods: {
        saveGame: function () {
            this.game.id = null;
            let p1 = new Promise((resolve, reject) => saveGame(this.game, resolve, reject));
            p1
                .then((value) => {
                    this.gamesList.push(value);
                    this.clearGameForm()
                })
                .catch((error) => console.log(error));

        },
        updateGame: function () {
            let updatePromise = new Promise((resolve, reject) => updateGame(this.game, resolve, reject));
            updatePromise
                .then((value) => {
                    this.refreshGames()
                    this.clearGameForm()
                })
                .catch((error) => console.log(error));
        },
        deleteGame: function () {
            let deleltePromise = new Promise((resolve, reject) => deleteGame(this.game.id, resolve, reject));
            deleltePromise
                .then((value) => {
                    var i = this.gamesList.indexOf(this.game);
                    if (i != -1) {
                        this.gamesList.splice(i, 1);
                    }
                    this.clearGameForm()
                })
                .catch((error) => console.log(error));
        },
        refreshGames: function () {
            let gamesPromise = new Promise((resolve, reject) => retrieveGames(resolve, reject));
            gamesPromise.then(games => {
                this.gamesList = games;
                this.gamesListLoading = false;
            }).catch(error => {
                this.gamesListErrored = true;
                console.log(error);
            })
        },
        clearGameForm: function () {
            this.game = {
                id: null,
                name: "",
                description: ""
            }
        },
        selectedGame: function (selectedGame) {
            this.game = selectedGame;
        }
    },
    mounted() {
        this.refreshGames();
    }
});

//REST Services...

function saveGame(game, resolve, reject) {
    axios.post('http://localhost:8080/private/v1/games', game)
        .then(function (response) {
            resolve(response.data);
        })
        .catch(function (error) {
            reject(error);
        });
}

function updateGame(game, resolve, reject) {
    axios.put('http://localhost:8080/private/v1/games/' + game.id, game)
        .then(function (response) {
            resolve(response.data);
        })
        .catch(function (error) {
            reject(error);
        });
}

function deleteGame(gameId, resolve, reject) {
    axios.delete('http://localhost:8080/private/v1/games/' + gameId)
        .then(function (response) {
            resolve(response.data);
        })
        .catch(function (error) {
            reject(error);
        });
}

function retrieveGames(resolve, reject) {
    axios
        .get('http://localhost:8080/private/v1/games')
        .then(response => {
            resolve(response.data.games);
        })
        .catch(error => {
            console.log(error);
            reject(error);
        })

}