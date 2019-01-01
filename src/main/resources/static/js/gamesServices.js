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