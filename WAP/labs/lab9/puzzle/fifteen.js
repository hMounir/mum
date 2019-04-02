"use strict";
class Table{
    constructor() {
        this.row = 0;
        this.col = 0;
    }
    setRow(row) {
        this.row = row;
    };
    setCol(col) {
        this.col = col;
    };
    getRow() {
        return this.row;
    };
    getCol() {
        return this.col;
    };
}
const puzzleModule = function(){
    const table = new Table();

    const drawPuzzleTable = function(squaresArea) {
        squaresArea.each(index => {
            let square = $(squaresArea[index]);
            // calculate x and y for every piece
            let x = ((index % 4) * 100);
            let y = (Math.floor(index / 4) * 100);
            // set basic style and background
            square.addClass('puzzlepiece')
                .css('left',x + 'px')
                .css('top',y + 'px')
                .css('background-image',"url('background.jpg')")
                .css('background-position',-x + 'px ' + (-y) + 'px');
            // store x and y for later
            square.x = x;
            square.y = y;
        });
        table.setRow(3);
        table.setCol(3);
    };

    const squareClicked = function(square){
        let left = parseInt(square.css("left"));
        let top = parseInt(square.css("top"));
        let rowLeft = table.getRow() * 100;
        let colTop = table.getCol() * 100;
        if (canMoveSquare(left, rowLeft, top, colTop)) {
            table.setRow(left / 100);
            table.setCol(top / 100);
            square.css("left", rowLeft + "px");
            square.css("top", colTop + "px");
        }
    };

    const squareHovered = function(squaresArea){
        let left = parseInt(squaresArea.css("left"));
        let top = parseInt(squaresArea.css("top"));
        let emptyLeft = table.getRow() * 100;
        let emptyTop = table.getCol() * 100;
        if (canMoveSquare(left, emptyLeft, top, emptyTop)) {
            squaresArea.addClass("movablepiece");
        }
    };

    const puzzleMouseout = function(puzzleArea){
        puzzleArea.removeClass("movablepiece");
    };

    const shuffleBtnClicked = function(squaresArea){
        let randomArr = [];
        let size = squaresArea.length;

        while (size >= 0) {
            while (true) {
                let randomNum = parseInt(Math.random() * 16);
                if (!contains(randomArr, randomNum)) {
                    randomArr.push(randomNum);
                    break;
                }
            }
            size--;
        }

        let x = ((randomArr[squaresArea.length] % 4));
        let y = (Math.floor(randomArr[squaresArea.length] / 4));
        table.setRow(x);
        table.setCol(y);

        squaresArea.each(function (i, value) {
            let x = ((randomArr[i] % 4) * 100);
            let y = (Math.floor(randomArr[i] / 4) * 100);
            $(value).css("left", x + "px");
            $(value).css("top", y + "px");
        });
    };

    const contains =function(squaresArray, square) {
        for (let i = 0; i < squaresArray.length; i++) {
            if (squaresArray[i] === square) {
                return true;
            }
        }
        return false;
    };

    const canMoveSquare = function(tileLeft, leftColumn, tileTop, topRow) {
        if (Math.abs(tileLeft - leftColumn) === 100 && tileTop === topRow) {
            return true;
        }
        return Math.abs(tileTop - topRow) === 100 && tileLeft === leftColumn;
    };

    return{
        drawPuzzleTable:drawPuzzleTable,
        puzzleClicked:squareClicked,
        puzzleHovered:squareHovered,
        puzzleMouseout:puzzleMouseout,
        shuffleBtnClicked:shuffleBtnClicked
    }
}();
$(document).ready(function() {
    let squaresArea = $("#puzzlearea div");
    puzzleModule.drawPuzzleTable(squaresArea);

    squaresArea.click(function () {
        puzzleModule.puzzleClicked($(this));
    }).hover(function () {
        puzzleModule.puzzleHovered($(this));
    }).mouseout(function () {
        puzzleModule.puzzleMouseout($(this));
    });
    $('#shufflebutton').click(function(){
        puzzleModule.shuffleBtnClicked(squaresArea);
    });
});