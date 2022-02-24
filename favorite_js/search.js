document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("p1").style.display = "none";
    document.getElementById("p2").style.display = "none";
    document.getElementById("form").onkeypress = (e) => {
        // form1に入力されたキーを取得
        const key = e.keyCode || e.charCode || 0;
        // 13はEnterキーのキーコード
        if (key == 13) {
          // アクションを行わない
          e.preventDefault();
        }
      }
      document.getElementById("form2").onkeypress = (e) => {
        // form1に入力されたキーを取得
        const key = e.keyCode || e.charCode || 0;
        // 13はEnterキーのキーコード
        if (key == 13) {
          // アクションを行わない
          e.preventDefault();
        }
      }
}, false);
//初期表示は非表示
//document.getElementById("p1").style.display ="none";
function clickBtn1() {
    const p1 = document.getElementById("p1");
    const id = "1044715390094874245";

    p1.style.display = "block";
    const isbn = document.getElementById("form").isbn.value;
    console.log(isbn);
    isbnSearch(isbn, id);
    //9784295005940,1044715390094874245
}

function clickBtn2() {
    const p1 = document.getElementById("p1");
    p1.style.display = "none";
}
async function isbnSearch(isbn, id) {
    const res = await fetch("https://app.rakuten.co.jp/services/api/BooksBook/Search/20170404" +
        "?format=json&isbn=" + isbn + "&applicationId=" + id);
    const bookInfo = await res.json();
    console.log(bookInfo);
    const image = bookInfo.Items[0].Item.smallImageUrl;
    console.log(image);
    document.getElementById("image").src=image;
    const title = bookInfo.Items[0].Item.title;
    document.getElementById("title").textContent = title;
    const author = bookInfo.Items[0].Item.author;
    document.getElementById("author").textContent = author;
    const date = bookInfo.Items[0].Item.salesDate;
    document.getElementById("date").textContent = date;
};
async function keySearch(key, id) {
  //https://app.rakuten.co.jp/services/api/BooksBook/Search/20170404
  //?format=json&title=%E5%A4%AA&applicationId=1028750289667141358
    const res = await fetch("https://app.rakuten.co.jp/services/api/BooksBook/Search/20170404" +
        "?format=json&title=" + key + "&applicationId=" + id);
    const bookInfo = await res.json();
    console.log(bookInfo);
    const keyResult=document.getElementById("keyResult");
    keyResult.innerHTML="";
    for(let item of bookInfo.Items){
        const isbn=item.Item.isbn;
        const image=item.Item.smallImageUrl;
        const title=item.Item.title;
        const author=item.Item.author;
        const price=item.Item.itemPrice;
        const date=item.Item.salesDate;
        //console.log(image,title,author,price,date);
        // servletでactionからisbnをもとに検索することでマイページに追加する
        keyResult.innerHTML+="<form action=\"SERVLET?action="+isbn+"\"method=\"post\">"
                            +"<p><img src="+image+"></p>"
                            +"<p>title:"+title+"</p>"
                            +"<p>author:"+author+"</p>"
                            +"<p>price:"+price+"</p>"
                            +"<p>date:"+date+"</p>"
                            +"<p><input type=\"submit\"value=\"追加\"></p>"
                            +"</form>";
    }
};
function clickBtn3() {
    const p2 = document.getElementById("p2");
    const id = "1044715390094874245";
    
    p2.style.display = "block";
    const key = encodeURI(document.getElementById("form2").key.value);
    console.log(key);
    keySearch(key, id);
    //9784295005940,1044715390094874245
}

function clickBtn4() {
    const p2 = document.getElementById("p2");
    p2.style.display = "none";
}