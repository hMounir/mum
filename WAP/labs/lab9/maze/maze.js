$(document).ready(function () {
    let start=false;
    let win=false;

    $(".boundary").mouseover(function(){
        if(start){
            $(this).addClass("youlose");
            $("#status").text("you Lose!!");
        }
    });
    $("#start").mouseover(function(){
        $(".boundary").removeClass("youlose");
        $("#status").text("Game start!");
        start=true;
        win=false;
    });
    $("#end").mouseover(function(){
        if(start){
            if($(".youlose").size() >=1){
                $("#status").text("You still lose!:");
            }else{
                $("#status").text("You Win!:]");
                win=true;
            }
        }
    });
    $("#maze").mouseleave(function(){
        if(start){
            if(!win){
                $("#status").text("You Lose! out of area");
                $(".boundary").addClass("youlose");
            }
        }
    });
});