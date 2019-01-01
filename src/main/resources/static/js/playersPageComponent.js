export default {
    template: '#playersPage-template',
    data() {
        return {
            player: {
                id: null,
                name: null
            },
            playerList: [],
            playerListLoading: true,
            playerListErrored: false
        }
    },
    methods: {
        savePlayer: function () {
            this.player.id = null;
            let p1 = new Promise((resolve, reject) => savePlayer(this.player, resolve, reject));
            p1
                .then((value) => {
                    this.playerList.push(value);
                    this.clearPlayerForm()
                })
                .catch((error) => console.log(error));
        },
        refreshPlayers: function () {
            let gamesPromise = new Promise((resolve, reject) => retrievePlayers(resolve, reject));
            gamesPromise.then(games => {
                this.playerList = games;
                this.playerListLoading = false;
            }).catch(error => {
                this.playerListErrored = true;
                console.log(error);
            })
        },
        selectedPlayer: function (p) {
           this.player = p;
        },
        clearPlayerForm: function () {
            this.player = {
                id: null,
                name: ""
            }
        }
    },
    mounted() {
        this.refreshPlayers();   
    }
}

function savePlayer(game, resolve, reject) {
    axios.post('http://localhost:8080/private/v1/players', game)
        .then(function (response) {
            resolve(response.data);
        })
        .catch(function (error) {
            reject(error);
        });
}
function retrievePlayers(resolve, reject) {
    axios
        .get('http://localhost:8080/private/v1/players')
        .then(response => {
            resolve(response.data.players);
        })
        .catch(error => {
            console.log(error);
            reject(error);
        })

}