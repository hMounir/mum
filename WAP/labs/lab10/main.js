function postUserId(){
    fetch('http://jsonplaceholder.typicode.com/users/'+$('#userId').val())
    .then(response => response.json())
    .then(json => {
        console.log(json);
        $('.chatBox').show();
       // document.getElementById('userName').innerHTML = json.username;
       $('.chatBox .posterDetails').children()[0].innerHTML = '<strong>User Name:</strong> '+ json.username;
       $('.chatBox .posterDetails').children()[1].innerHTML = '<strong>Email:</strong> '+ json.email;
       $('.chatBox .posterDetails').children()[2].innerHTML = '<strong>Address:</strong> '+ json.address.street +
       ',' + json.address.suite + ',' + json.address.city;
       showPosts();
    });
        
}

function showPosts(){
    fetch('http://jsonplaceholder.typicode.com/posts?userId='+$('#userId').val())
    .then(response => response.json())
    .then(json => {
        console.log(json);
        let postsDiv = "<div>";
        Object.keys(json).forEach(function(key) {
            let value = json[key];

            $('.chatBox .posts').append("<div class='postDetails'><p style='padding-top:15px;padding-left: 20px;'>"+value.title+"</p>" +
                "<p style='padding-left: 80px;'>"+value.body+"</p>"+
                "<div style='text-align: right;padding-bottom: 20px;padding-right: 35px;'>"+
                "<button onclick='showComments(event,"+value.id+");'>Show Comments</button>"
                +"</div>"+
                '</div>');

            postsDiv+= '<dt>'+value.title+'</dt>';
        });
        postsDiv+="</div>";
        console.log(postsDiv);
    });
}

function showComments(event,postId){
    fetch('http://jsonplaceholder.typicode.com/comments?postId='+postId)
    .then(response => response.json())
    .then(json => {
        console.log(json);
        Object.keys(json).forEach(function(key) {
            let value = json[key];
            $(event.srcElement.parentElement.parentElement).after("<div class='commentsSection'>"+
                      "<div class='commentName'><strong>Name:</strong> "+value.name+"</div>"+
                      "<div class='commentEmail'><strong>Email:</strong> "+value.email+"</div>"+
                      "<div class='commentBody'>"+value.body+"</div>"+
                      "</div>");
        });
    });
}