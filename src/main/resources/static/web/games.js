var data;

fetch("/api/games", {

    method: "GET"

}).then(function (response) {
    if (response.ok) {
        return response.json();
    }
    throw new Error(response.statusText);
}).then(function (json) {

    // do something with json data

    games = json;

showGames();
showLeaders();

});

function showGames() {
// Create a function that puts the game data in the main webpage
for (i=0; i < games.length; i++ ) {

    var gamesList = document.getElementById("gameList");
    var newListItem = document.createElement("li");

    gamesList.appendChild(newListItem);

    if (games[i].gamePlayers.length == 2) {

        newListItem.innerHTML = games[i].dateCreated + ", " + games[i].gamePlayers[0].player.email + " VS " + games[i].gamePlayers[1].player.email;

        }

    else {
     newListItem.innerHTML = games[i].dateCreated + ", " + games[i].gamePlayers[0].player.email + " VS Waiting for Opponent";

    }
}
}

// This function is going to put the data in the leaderboard table

// Create a function for the leaderboard
function showLeaders() {
    var scores = [];
// Go through all of the games
    for (i=0; i < games.length; i++) {
// Then for each games[i].scores.length add to an array scores
        for (j = 0; j < games[i].scores.length; j++) {
            scores.push(games[i].scores[j]);
        }
    }
    console.log(scores);
}

