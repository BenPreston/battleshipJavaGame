 //window.location.href
var url = new URL(window.location.href);
console.log(url);
var c = url.searchParams.get("gp");
getPlayerData(c);

// I want to make a function that creates a table

// So first thing is to call a function that has paremeters of row and columns

function makeTable(row, column, tableLocation, playerType) {
    var rows = row;
    var columns = column;

// I then want to make it so that it creates a new variable of table

    var newTable = document.createElement("table");

    // I´ve made it so that you can choose the size of table which could come in handy laterif for instance I wanted to pick a game size. So this will create the table

    for(var i =0; i < rows; i++){

    // here I want to add it so that the first row contains letters

         var tableRows = document.createElement("tr");

    // append the table rows to the table

    newTable.appendChild(tableRows);

    // create a column
    for (var j = 0; j < columns;j++ ){
    var tableColumns = document.createElement("td");

    // Here I´ve set the ID of each cell to be A4 or B3 or whatver

    tableColumns.id = toLetters(i).toString() + j.toString() + playerType;

    if ((i == 0) && (j != 0)) {
        tableColumns.innerHTML = (j);
    }

    if ((j == 0) && (i != 0)) {
        tableColumns.innerHTML = toLetters(i);
    }
        // append each of the columns to every one of the rows

    tableRows.appendChild(tableColumns);
    }

    // then put the table in the page
     document.getElementById(tableLocation).appendChild(newTable);
    }
}

    // This function should turn the numbers into letters

    function toLetters(num) {
        "use strict";
        var mod = num % 26,
            pow = num / 26 | 0,
            out = mod ? String.fromCharCode(64 + mod) : (--pow, 'Z');
        return pow ? toLetters(pow) + out : out;
    }


makeTable(11, 11, "playerTable", "C");
makeTable(11, 11, "opponentTable", "O");

// Now I´ve made the table I want to be able to call on the detail from the JSON file of players

function getPlayerData(gamePlayer) {
    fetch(("/api/game_view/" + gamePlayer), {

        method: "GET"

    }).then(function (response) {
        if (response.ok) {
            return response.json();
        }
        throw new Error(response.statusText);

    }).then(function (json) {

        // do something with json data

        data = json;

showPlayerShips();
putPlayerNamesOnPage();
showSalvoesShot(data.salvoesFired,"O");
showSalvoesReceived(data.salvoesReceived,"C");


    }).catch(function (error) {
        //called when there's an error
        console.log("Request failed " + error.message);

        $("#alert").modal("show");
//        alert("player not found. Please check your spelling or records");

    });
}

// Now I want to write a function that places some dashes in the boxes depending on whether the player has these ships.
// I called the function in the fetch as otherwise it wouldn´t work

function showPlayerShips() {

       for (i = 0; i < data.ships.length; i++) {
            for (j = 0; j < data.ships[i].shipPosition.length; j++) {

                var writeShip = document.getElementById(data.ships[i].shipPosition[j] + "C");
                writeShip.className += "ship";
            }
       }
}

// Now I want to write a function that puts the game player and opponent at the top of the page

function putPlayerNamesOnPage() {

// So here I want to loop through the game players
for (i = 0; i < data.gamePlayers.length; i++) {
    var thisGamePlayerNum = url.searchParams.get("gp");

    if (data.gamePlayers[i].gamePlayerID == thisGamePlayerNum) {
        var thisGamePlayerID = data.gamePlayers[i].gamePlayerID;
        var gamePlayerDetails = document.getElementById("you");
        gamePlayerDetails.innerHTML = data.gamePlayers[i].player.email;
    }
    else {
        var challengerNum = data.gamePlayers[i].gamePlayerID;
        var challenger = document.getElementById("challenger");
        challenger.innerHTML = data.gamePlayers[i].player.email;
    }
}
}

// Now I want to write a function that puts the salvoes on the other grid.
function showSalvoesReceived(shotOrReceived, OppOrChall) {

for (i = 0; i < shotOrReceived.length; i++) {
    for (j = 0; j < shotOrReceived[i].position.length; j++) {

        var writeSalvo = document.getElementById(shotOrReceived[i].position[j] + OppOrChall);

if (writeSalvo.className == "ship") {
      writeSalvo.className += "salvo";
      writeSalvo.textContent = shotOrReceived[i].turn;
      }
    }
    }
}

// Then do the received. It´s been made a second function just for ease of filtering the non shots

function showSalvoesShot(shotOrReceived, OppOrChall) {

for (i = 0; i < shotOrReceived.length; i++) {
    for (j = 0; j < shotOrReceived[i].position.length; j++) {

        var writeSalvo = document.getElementById(shotOrReceived[i].position[j] + OppOrChall);

      writeSalvo.className += "salvo";
      writeSalvo.textContent = shotOrReceived[i].turn;
      }
    }
}

