//Estos componentes se tendrás que recuperar del servicio http
var components = [
    { id: 1, value: 'Games', uri: '' },
    { id: 2, value: 'Players', uri: '' }
]

var games = [
    { id: 1, name: 'Amigo invisible', description: 'Juega con tu familia y haceros un regalo divertido' },
    { id: 2, name: 'Sudoku', description: 'Juego de inteligencia matemática' },
    { id: 3, name: 'Aventureros al tren', description: 'Juego de mesa en el que descubriras las aventuras de viajar en tren ' }
]



var vmNavbar = new Vue({
    el: '#mainNavbars',
    data: {
        components: components
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
                this.data = response.data
            })
            .catch(error => {
                console.log(error)
                this.errored = true
            })
            .finally(() => this.loading = false)
    },
})