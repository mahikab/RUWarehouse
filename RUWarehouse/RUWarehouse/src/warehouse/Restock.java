package warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        Warehouse w = new Warehouse();
        int n = StdIn.readInt();

        for (int i = 1; i < n+1; i++){
            String query = StdIn.readString();

            if (query.startsWith("add")){
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                String name = StdIn.readString();
                int stock = StdIn.readInt();
                int demand = StdIn.readInt();
                w.addProduct(id, name, stock, day, demand);
            }
            
            else if (query.startsWith("restock")){

                int id2 = StdIn.readInt();
                int amount = StdIn.readInt();
                for (int j = 1; j < w.getSectors()[id2 % 10].getSize()+1; j++){
                    if (w.getSectors()[id2 % 10].get(j).getId() == id2){
                        int initialStock = w.getSectors()[id2 % 10].get(j).getStock();
                        w.getSectors()[id2 % 10].get(j).setStock(initialStock + amount);
                    }
                }
                //w.getSectors()[id % 10].get(id).updateStock(amount);
            }
        }
        StdOut.println(w);
	
    }
}
