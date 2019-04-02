(function () {
    'use strict';
    let BikeModule = (function(){
        let createBicyclePrototype = function () {
            return {
                speed:0,
                applyBrake: function (speed) {
                    this.speed-=speed;
                },
                speedup: function (speed) {
                    this.speed+=speed;
                }
            };
        };

        let createMountainBikePrototype = function (prototype) {
            let bike =  Object.create(prototype);
            bike.gear = 1;
            let setGear = function(gear){
                bike.gear = gear;
            };
            return {
                bike: bike,
                setGear:setGear
            };
        };

        const start = function () {
            let bicyclePrototype = createBicyclePrototype();
            let mountainBikePrototype = createMountainBikePrototype(bicyclePrototype);
            console.log(bicyclePrototype);
            console.log(mountainBikePrototype);

            let newBicyclePrototype = Object.create(bicyclePrototype);
            let mewMountainBikePrototype = Object.create(mountainBikePrototype);
            console.log(newBicyclePrototype);
            console.log(mewMountainBikePrototype);
        };

        return {
            start:function(){
                return start();
            }
        };
    })();

    class Bike {
        constructor() {
            this._speed = 0;
            this._gear = 0;
        }
        getSpeed() {
            return this._speed;
        }

        setSpeed(speed){
            this._speed = speed;
        }

        getGear() {
            return this._gear;
        }

        setGear(gear){
            this._gear = gear;
        }

        applyBrake(speed) {
            this._speed-=speed;
        }
        speedup(speed) {
            this._speed+=speed;
        }

        toString() {
            return "{" +
                    "speed:" + this._speed
                    +" gear:" + this._gear+
                "}";
        }
    }

    window.onload = ev => {
        console.log("bike created using prototype");
        BikeModule.start();
        console.log("bike created using class");
        let bicycle = new Bike();
        console.log("bike is " + bicycle);

        let mountainBike = new Bike();
        mountainBike.setGear(1);
        console.log("mountainBike is " + mountainBike);

        let newBicycle = Object.create(bicycle);
        console.log("bike created using object.create " + newBicycle);

        let mewMountainBike = Object.create(mountainBike);
        console.log("mountainBike created using object.create " + mewMountainBike);
    };
})();