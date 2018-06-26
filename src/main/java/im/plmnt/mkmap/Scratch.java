package im.plmnt.mkmap;

class Scratch {

    static class User {

        @PrimaryKey Integer userId;
        @SecondaryKey String name;

        User(Integer userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        MKMap<Integer, String, User> map = new HashBasedMKMap<>();

        User u1 = new User(1, "Tony Montana");
        User u2 = new User(2, "Vladimir Putin");

        map.put(u1);
        map.put(u2);

        System.out.println(u1 == map.getByPrimaryKey(u1.userId));
        System.out.println(u1 == map.getBySecondaryKey(u1.name));

        System.out.println(u2 == map.getByPrimaryKey(u2.userId));
        System.out.println(u2 == map.getBySecondaryKey(u2.name));

        User u3 = new User(1, "Donald Trump");
        map.put(u3);

        System.out.println(u3 == map.getByPrimaryKey(u3.userId));
        System.out.println(u3 == map.getBySecondaryKey(u3.name));

        System.out.println(u1 != map.getByPrimaryKey(u1.userId));
        System.out.println(u1 != map.getBySecondaryKey(u1.name));
    }
}