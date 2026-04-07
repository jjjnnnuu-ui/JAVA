void main() throws IOException {
    Customer[] customers = new Customer[] {
            new Customer("홍길동", "1234", '1'),
            new Customer("홍길동", "2234", '2'),
            new Customer("홍길동", "3234", '3'),
            new Customer("홍길동", "1234", '4'),
            new Customer("홍길동", "1234", '5')
    };

    WaterOffice office = new WaterOffice(customers);
    office.inputData();
    office.display();
}