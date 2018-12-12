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

var vmNavbar = new Vue({
    el: '#gamesTable',
    data: {
        games: games
    }
})