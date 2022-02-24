document.addEventListener('DOMContentLoaded',function(){
    let timerId;
    let count=0;
    timerId=window.setInterval(function(){
        let images=["../img/daikichi.png","../img/chukichi.png","../img/suekichi.png","../img/kyo.png"];
        count++;
        if(count===4){
            count=0;
        }
        document.getElementById("image").src=images[count];
    },1000);
});