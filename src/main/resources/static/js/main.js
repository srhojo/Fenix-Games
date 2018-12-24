import FgNavbar from './navbarComponent.js'


var vmNavBar = new Vue({
    el: '#mainNavbars',
    components: {
        'fg-navbar': FgNavbar
      },
    data: {
        components: [{
                id: 1,
                value: 'Games',
                uri: ''
            },
            {
                id: 2,
                value: 'Players',
                uri: ''
            }]
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


// 1. Define route components.
// These can be imported from other files
const Foo = { template: '<div>foo</div>' }
const Bar = { template: '<div>bar</div>' }

// 2. Define some routes
// Each route should map to a component. The "component" can
// either be an actual component constructor created via
// `Vue.extend()`, or just a component options object.
// We'll talk about nested routes later.
const routes = [
  { path: '/foo', component: Foo },
  { path: '/bar', component: Bar }
]

// 3. Create the router instance and pass the `routes` option
// You can pass in additional options here, but let's
// keep it simple for now.
const router = new VueRouter({
  routes // short for `routes: routes`
})

// 4. Create and mount the root instance.
// Make sure to inject the router with the router option to make the
// whole app router-aware.
const app = new Vue({
  router
}).$mount('#app')