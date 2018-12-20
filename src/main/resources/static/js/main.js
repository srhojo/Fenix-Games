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
    data:{
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
            console.log('Vamos a añadir el juevo --> Nombre: ' + this.game.name + ', Descripcion: ' + this.game.description)
        },
        updateGame: function () {
            console.log('Vamos a actualizar el juevo --> Nombre: ' + this.game.name + ', Descripcion: ' + this.game.description)
        }
    },
    mounted() {
        axios
            .get('http://localhost:8080/private/v1/games')
            .then(response => {
                this.gamesList = response.data;
            })
            .catch(error => {
                console.log(error);
                this.gamesListErrored = true;
            })
            .finally(() => this.gamesListLoading = false);
    }
});