void main() {
    Engine engine = new Engine();
    Car car = new Car(engine);

    car.drive();
    car.stop();
}