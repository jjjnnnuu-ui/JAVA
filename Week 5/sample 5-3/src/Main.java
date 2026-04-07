void main() throws IOException {


    Customer[] customers = new Customer[] {
            new Customer("홍길동", "1234", new Home()),
            new Customer("홍길동", "2234", new Business()),
            new Customer("홍길동", "3234", new Factory()),
            new Customer("홍길동", "1234", new Government()),
            new Customer("홍길동", "1234", new Army())
    };

    WaterOffice office = new WaterOffice(customers);
    office.inputData();
    office.display();
}