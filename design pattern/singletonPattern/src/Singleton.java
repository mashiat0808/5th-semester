class Database {

    private static Database dbInstance;

    private Database(){
        System.out.println("returning DB");
    }
    public static Database getDatabase(){
        if(dbInstance== null){
            dbInstance= new Database();
        }
        return dbInstance;
    }

    public void getConnection() {
        System.out.println("Connected to the database.");
    }
}
