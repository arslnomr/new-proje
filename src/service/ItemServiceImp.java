package service;

import database.Database;
import entity.Item;
import exception.ItemNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;

public class ItemServiceImp implements ItemService{
    @Override
    public List<Item> getAllItems() {
        return Database.items;
    }

    @Override
    public Item getItemById(int id) throws ItemNotFoundException {
        for (Item i:Database.items)
        {
                if (i.getId()==id)
                {
                    return i;
                }
        }
        throw new ItemNotFoundException("Böyle bir ürün yok işine bak.");

    }

    @Override
    public void addItem(Item item) {
        Database.items.add(item);

    }

    @Override
    public void deleteItemById(int id) throws ItemNotFoundException {
        for (Item e:Database.items)
        {
            if (e.getId()==id)
            {
                Database.items.remove(e);
            }
        }
        throw new ItemNotFoundException("Ürün bulunamadı.");

    }

    @Override
    public void updateItem(Item item) {
        try {
            for (Item c : Database.items)
            {

                if (c != item)
                {
                    Database.items.add(c);
                }


            }
        }catch (Exception k)
        {
            System.out.println(k);
        }
    }

    // ItemService icerisinde tanilanmis govdesiz tum methodlarin implementation unu bu class da yapacaksiniz...
    // Class ismindeki KIRMIZI ikaza giderseniz 'implement mothods' secenegini goreceksiniz... Onu secin ve baslayin...
    // GetAllItems methodu Database e gidip oradan butun item lari alir ve bir List olarak return eder...
    // getItemById methodu parametre olarak aldigi id ile Database de boyle bir item var mi diye kontrol eder,
    // yoksa, ItemNotFound exception firlatir, varsa ilgili item i return eder...
    // addItem methodu, parametre olarak aldigi item i Database deki items listesine ekler...
    // deleteItemById methodu parametre olarak aldigi id ile Database de o urunu arar, bulamazsa ItemnotFound exception firlatir
    // ilgili item mevcut ise onu Database list inden siler...



    // updateItem methodu parametre olarak aldigi Item i Database de arar, yoksa ItemNotFound exception firlatir,
    // Varsa Datalase deki items listesinden silip, guncel halini Database List ine ekler...

}
