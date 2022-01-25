
$(document).ready(function(){
    posts();
} );



function posts() {
    $.ajax({
        type: "GET",
        url : "/posts",
        success : function (response){
            console.log(response);
            for(let i =0; i<response.length; i++) {
                let str = response[i].time;
                $('.posts').append(`
            <div>제목: ${response[i].title} 작성자:${response[i].name} 작성날짜:${str.substring(0,19)} <button onclick='post(${response[i].id})'>글 보러가기</button></div>
            <hr>
            `);
            }
        }
    })
}

function post(id){
            window.location.href =`/posts/${id}`;
}



