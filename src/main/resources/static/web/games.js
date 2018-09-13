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

        newListItem.innerHTML = games[i].dateCreated + ", " + games[i].gamePlayers[0].player.email + " VS " + games[i].gamePlayers[1].player.email;

}
}