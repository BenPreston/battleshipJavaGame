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
        var sortedScores = scores.sort(function(a, b) {
            return a.playerID - b.playerID
        })

let clone = JSON.parse(JSON.stringify(sortedScores));
//let clone = sortedScores;
    var uniqueUsers = [];

    // Add the first user in the sorted scores list to this list
    uniqueUsers.push(clone[0]);

    // Then once this is done go thorugh the sorted list from position [1] and if the playerID at [i] != [i-1] then add it to the unique users array
    for (i=1; i < clone.length; i++) {
        if (clone[i].playerID != clone[i-1].playerID) {
            uniqueUsers.push(clone[i]);
        }
    }

   // Then for each item in the list add the parameters win, losses, draws, points

   for (x=0; x < uniqueUsers.length; x++) {
        uniqueUsers[x].wins = 0;
        uniqueUsers[x].draws = 0;
        uniqueUsers[x].losses = 0;
        uniqueUsers[x].points = 0;
        uniqueUsers[x].average = 0.1;
        delete uniqueUsers[x].score;
        delete uniqueUsers[x].scoreID;
        }

        for (i=0; i < uniqueUsers.length; i++) {
        for (j=0; j < sortedScores.length; j++) {
            if (uniqueUsers[i].playerID == sortedScores[j].playerID) {
                if (sortedScores[j].score == 1) {
                    uniqueUsers[i].wins += 1;
                    uniqueUsers[i].points += 1;
                }
                 else if (sortedScores[j].score == 0.5) {
                                    uniqueUsers[i].draws += 1;
                                    uniqueUsers[i].points += 0.5;
                                }
                 else if (sortedScores[j].score == 0) {
                    uniqueUsers[i].losses += 1;
                    }
            }
        }
   }

// Then I want to go through this list of unique users and for every score value if the score is equal to 1 I want to the points etc

   console.log(uniqueUsers);
   console.log(sortedScores);

    for (i=0; i < uniqueUsers.length; i++) {
        uniqueUsers[i].average = uniqueUsers[i].points / (uniqueUsers[i].wins + uniqueUsers[i].draws + uniqueUsers[i]
        .losses);
    }

      uniqueUsers.sort(function(a, b) {
                return b.average - a.average;
            })

    var playerTable = document.getElementById("leaderboard");

    for(i=0; i < uniqueUsers.length; i++) {
        var tableRows = document.createElement("tr");
        var playerCol = document.createElement("td");
        var winCol = document.createElement("td");
        var drawCol = document.createElement("td");
        var lossCol = document.createElement("td");
        var pointCol = document.createElement("td");
        var avPointCol = document.createElement("td");

        playerTable.appendChild(tableRows);
        tableRows.appendChild(playerCol);
        tableRows.appendChild(winCol);
        tableRows.appendChild(drawCol);
        tableRows.appendChild(lossCol);
        tableRows.appendChild(pointCol);
        tableRows.appendChild(avPointCol);

        playerCol.innerHTML = uniqueUsers[i].playerUsername;
        winCol.innerHTML = uniqueUsers[i].wins;
        drawCol.innerHTML = uniqueUsers[i].draws;
        lossCol.innerHTML = uniqueUsers[i].losses;
        pointCol.innerHTML = uniqueUsers[i].points;
        avPointCol.innerHTML = uniqueUsers[i].average;
        
    }

}

