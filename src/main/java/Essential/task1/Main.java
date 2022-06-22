package Essential.task1;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        System.out.println();
        System.out.println("============ Перевірка методу addElement та toString ============");
        list.addElement(0);
        list.addElement("test_one");
        System.out.println("Два перших елементи різного типу: " + list);

        System.out.println();
        System.out.println("============ Перевірка методу getByIndex ============");
        System.out.println("Перший елемент по індексу 0: " + list.getByIndex(0));
        System.out.println("Другий елемент по індексу 1: " + list.getByIndex(1));

        System.out.println();
        System.out.println("============ Перевірка динамічного розширення масиву ============");
        for (int i = 2; i < 11; i++) {
            list.addElement("test" + i);
            System.out.println(list);
        }

        System.out.println();
        System.out.println("============ Перевірка методу size ============");
        System.out.println("Розмір 'ліста': " + list.size());

        System.out.println();
        System.out.println("============ Перевірка методу contains ============");
        Object foo = "tes3";
        if (list.contains(foo)) {
            System.out.println("Ваш об'єкт " + foo + " знаходиться в 'лісті'");
        } else System.out.println("Вашого об'єкта " + foo + " немає в 'лісті'");
        Object bar = 0;
        if (list.contains(bar)) {
            System.out.println("Ваш об'єкт " + bar + " знаходиться в 'лісті'");
        } else System.out.println("Вашого об'єкта " + bar + " немає в 'лісті'");

        System.out.println();
        System.out.println("============ Перевірка методу remove ============");
        System.out.println("Розмір 'ліста': " + list.size());
        list.remove(3);
        System.out.println("Ми видалили елемент test3 за індексом 3");
        System.out.println(list);
        System.out.println("Розмір 'ліста': " + list.size());

        System.out.println();
        System.out.println("============ Перевірка методу clear ============");
        list.clear();
        System.out.println(list);

        System.out.println();
        System.out.println("============ Перевірка методу addByIndex ============");
        for (int i = 0; i < 12; i++) {
            list.addElement(i);
        }
        System.out.println(list);
        System.out.println("Розмір до додавання: " + list.size());
        list.addByIndex("test by index", 2);
        System.out.println(list);
        System.out.println("Розмір після додавання: " + list.size());

    }
}
