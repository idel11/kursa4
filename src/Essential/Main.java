package Essential;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        System.out.println("============ Перевірка метода addElement та toString ============");
        list.addElement(0);
        list.addElement("test_one");
        System.out.println("Два перших едементи різного типу: " + list);

        System.out.println("============ Перевірка метода getByIndex ============");
        System.out.println("Перший елемент по індексу 0: " + list.getByIndex(0));
        System.out.println("Другий елемент по індексу 1: " + list.getByIndex(1));

        System.out.println("============ Перевірка динамічного розширення масиву ============");
        for (int i = 2; i < 10; i++) {
            list.addElement("test" + i);
            System.out.println(list);
        }

        System.out.println("============ Перевірка методу size ============");
        System.out.println("Розмір ліста: " + list.size());

        System.out.println("============ Перевірка методу addByIndex ============");
        list.addByIndex("test by index", 2);
        System.out.println(list);
    }
}
