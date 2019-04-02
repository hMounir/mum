const shoppingCartModule = (function () {

    let shoppingCart = [];

    class Item {

        constructor(name,price,count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        getPrice() {
            return this.price;
        }

        getCount() {
            return this.count;
        }
    }

    const addItemToCart = function (name,price,count) {
        let item = new Item(name,price,count);

        let body = JSON.stringify(item);
        postData(`products?requestType=add`, body)
            .then(data => {
                shoppingCart.push(item);
                updateCart();
            })
            .catch(error => console.error(error));
    };

    const updateCart = function() {
        let output = "";

        shoppingCart.forEach(item => {
            output+="<li>"
                +item.name
                +" <div> Price: "+item.price +"</div>"
                +"<button class='delete-item' data-name='"+item.name+"'>X</button></div>"
                +"</li>";
        });
        $("#show-cart").html(output);
        $("#count-cart").html(countItems());
        $("#total-cart").html(totalCost());
    };

    const removeItemFromCart = function(name){
        console.log(name);
        shoppingCart.forEach(item => {
            if(item.name===name){
                // shoppingCart.splice(item,1);
                shoppingCart.splice(
                    shoppingCart.indexOf(item), 1
                );
            }
        });
        console.log(shoppingCart);
        updateCart();
    };

    const clearCart = function(){
        shoppingCart = [];
        updateCart();
    };

    const countItems = function(){
        let count=0;
        shoppingCart.forEach(item => {
            count += item.count;
        });
        return count;
    };

    const totalCost = function(){
        let cost = 0;
        shoppingCart.forEach(item => {
            cost+= item.getPrice() * item.getCount();
        });
        return cost.toFixed(2);
    };

    const listProducts = function(){
        let products = [];
        fetch('products')
            .then(function(response) {
                return response.json();
            })
            .then(function(items) {
                items.forEach(function(element){
                    let elementDiv =
                        "<a href=\"#\" class=\"listRow add-to-cart\" data-name=\""+element.name+"\" data-price=\""+element.price+"\">\n" +
                        "                    <div>\n" +
                        "                        <h2>Name: "+element.name+"</h2>\n" +
                        "                        <p>Price: "+element.price+"</p>\n" +
                        "                    </div>\n" +
                        "                </a>";

                    $('.firstColumn .row').append(elementDiv);
                    products.push(element);
                });
            });
        return products;
    };

    return{
        shoppingCartList:shoppingCart,
        addItemToCart:addItemToCart,
        removeItemFromCart:removeItemFromCart,
        clearCart:clearCart,
        listProducts:listProducts,
        totalCost:totalCost
    }
})();

function postData(url,data) {
    return fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: data,
    })
        .then(response => response.text());
}

$(document).ready(function () {

    shoppingCartModule.listProducts();

    $(".firstColumn .row").on("click", ".add-to-cart", function(){
        event.preventDefault();
        let name=$(this).attr("data-name");
        let price=Number($(this).attr("data-price"));

        shoppingCartModule.addItemToCart(name,price,1);
        $(this).css('display',"none");
    });

    $("#show-cart").on("click",".delete-item",function(){
        let name=$(this).attr("data-name");
        shoppingCartModule.removeItemFromCart(name);
        $(".add-to-cart[data-name='"+name+"']").css('display',"block");

    });

    $("#clear-cart").click(function(){
        shoppingCartModule.clearCart();
        $('.add-to-cart').css('display',"block");
    });

    $("#checkout").click(function(){
        $("#totalCost").val(shoppingCartModule.totalCost());
        //let body = JSON.stringify({
          //  products:shoppingCartModule.shoppingCartList,
            //totalCost:shoppingCartModule.totalCost()
        //});
       // postData(`products`, body)
         //   .then(data => {
           //     if(data === 'login.jsp'){
             //       alert('you need to login first in order to login');
               // }
      //          window.location.href = "products?requestType=checkout";
            //})
            //.catch(error => console.error(error));
    });
});