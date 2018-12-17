//Estos componentes se tendrás que recuperar del servicio http
var components = [
    { id: 1, value: 'Games', uri: '' },
    { id: 2, value: 'Players', uri: '' }
];



var vmNavbar = new Vue({
    el: '#mainNavbars',
    data: {
        components: components
    }
})

var vmGamesForm = new Vue({
    el:'#gamesForm',
    data() {
        return {
            game:{
                id: null,
                name: "",
                description: ""
            }
        }
    },
    methods:{
        saveGame : function () {
            console.log('Vamos a añadir el juevo --> Nombre: '+this.game.name+', Descripcion: '+this.game.description)
        },
        updateGame : function () {
            console.log('Vamos a actualizar el juevo --> Nombre: '+this.game.name+', Descripcion: '+this.game.description)
        }
    }
})

var vmGamesTable = new Vue({
    el: '#gamesTable',
    data() {
        return {
            data: null,
            loading: true,
            arrored: false

        }
    },
    mounted() {
        axios
            .get('http://localhost:8080/private/v1/games')
            .then(response => {
                this.data = response.data;
            })
            .catch(error => {
                console.log(error);
                this.errored = true;
            })
            .finally(() => this.loading = false);
    },
});

