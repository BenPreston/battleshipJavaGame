function makeTable(row, column) {
    var rows = row;
    var columns = column;

    // create a table

    var newTable = document.createElement("table");

    // for however many values of row exist add this number of rows to the table

    for(var i =0; i < rows; i++){

    var tableRows = document.createElement("tr");

    // append the table rows to the table

    newTable.appendChild(tableRows);

    // create a column
    for (var j = 0; j < columns;j++ ){
    var tableColumns = document.createElement("td");
    tableColumns.innerHTML = (i+1) * (j+1);
    

    // append each of the columns to every one of the rows

    tableRows.appendChild(tableColumns);
    }

    // then put the table in the page
     document.getElementById("myTable").appendChild(newTable);
    }
}

makeTable(10, 10);