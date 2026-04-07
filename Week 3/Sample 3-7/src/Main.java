void main() {
    ElectricCar car = new ElectricCar();
    car.charge();
    car.drive();
    car.stop();

    SportsCar sportsCar = new SportsCar();
    sportsCar.drive();
    sportsCar.turboBoost();
    sportsCar.stop();
}