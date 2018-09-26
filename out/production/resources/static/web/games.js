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

});

function showGames() {
// Create a function that puts the game data in the main webpage
for (i=0; i < games.length; i++ ) {

    var gamesList = document.getElementById("gameList");
    var newListItem = document.createElement("li");

    gamesList.appendChild(newListItem);

//    if (gamePlayers[0].player.email && gamePlayers[1].player.email) {

        newListItem.innerHTML = games[i].dateCreated + ", " + games[i].gamePlayers[0].player.email + " VS " + games[i].gamePlayers[1].player.email;

//        }

    else {
        newListItem.innerHTML = "Game not yet started";
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
        for (j = 0; j < games[i].length; j++) {
            push.scores(games[i].length[j]);
        }
    }
    console.log(scores);
}