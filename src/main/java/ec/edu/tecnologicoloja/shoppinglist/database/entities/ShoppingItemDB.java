package ec.edu.tecnologicoloja.shoppinglist.database.entities;

import android.content.Context;
import android.provider.BaseColumns;

import java.util.ArrayList;

import ec.edu.tecnologicoloja.shoppinglist.database.helper.ShoppingElementHelper;
import ec.edu.tecnologicoloja.shoppinglist.database.model.ShoppingItem;



public class ShoppingItemDB {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private ShoppingElementHelper dbHelper;

    SQLiteDatabase db = this.getWritableDatabase();

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ShoppingItemDB(Context context) {
        // Create new helper
        dbHelper = new ShoppingElementHelper(context);
    }

    /* Inner class that defines the table contents */
    public static abstract class ShoppingElementEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                COLUMN_NAME_TITLE + TEXT_TYPE + " )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    /**
     * Method to create new element in the database
     *
     * @param productName
     */
    public void insertElement(String productName) {
        ContentValues contenedor = new ContentValues();
        contenedor.put(ShoppingElementEntry.COLUMN_NAME_TITLE, productName);
        try {

            db.insert(ShoppingElementEntry.TABLE_NAME,null, contenedor);
            mensaje = "Ingresado Correctamente";
        }catch (SQLException e){
            mensaje = "NO Ingresado";
        }

    }


    public ArrayList<ShoppingItem> getAllItems() {
        ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();
        //TODO: add all the needed code to get all the database items
        return shoppingItems;
    }

    public void clearAllItems() {
        //TODO: add all the needed code to clear all the database items
    }

    public void updateItem(ShoppingItem shoppingItem) {
        //TODO: add the needed code to update a database item
        ContentValues valores = new ContentValues();
        valores.put(ShoppingElementEntry.COLUMN_NAME_TITLE,shoppingItem);

        db.update(ShoppingElementEntry.TABLE_NAME, valores, "id='"+shoppingItem+"'", null);
    }

    public void deleteItem(ShoppingItem shoppingItem) {
        //TODO: add all the needed code to delete a database item
        db.delete(ShoppingElementEntry.TABLE_NAME, "id='"+shoppingItem+"'", null);
    }
}
