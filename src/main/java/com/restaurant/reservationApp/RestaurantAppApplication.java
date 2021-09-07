package com.restaurant.reservationApp;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.drink.DrinkService;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeService;
import com.restaurant.reservationApp.food.Food;
import com.restaurant.reservationApp.food.FoodService;
import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.guest.GuestService;
import com.restaurant.reservationApp.menu.Menu;
import com.restaurant.reservationApp.menu.MenuService;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication

public class RestaurantAppApplication {


    @Autowired
    private DrinkService drinkService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private TableService tableService;
    @Autowired
    private MenuService menuService;

    public static void main(String[] args) {

        SpringApplication.run(RestaurantAppApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        final List<Drink> drinkList = new ArrayList<>(Arrays.asList(
//                new Drink(1, "CocoCola", "Soft", 100, "box", 1.5),
//                new Drink(2, "Pepsi", "Soft", 200, "box", 1),
//                new Drink(3, "Corona", "Beer", 300, "bottle", 3),
//                new Drink(4, "Chivas", "Whiskey", 400, "bottle", 10),
//                new Drink(5, "Spa", "Soft", 100, "bottle", 1),
//                new Drink(6, "Dujardin Blauw", "Brandy", 200, "bottle", 20),
//                new Drink(7, "Heneiken", "Beer", 300, "bottle", 3),
//                new Drink(8, "LeCola", "Soft", 200, "box", 1),
//                new Drink(9, "Guiness", "Beer", 200, "bottle", 3)
//
//        ));
//        final List<Employee> employeeList = new ArrayList<>(Arrays.asList(
//                new Employee(1, "Aysegul", "Aydar", "aysegul.aydar", "aysegul.aydar", "ADMIN"),
//                new Employee(2, "Ayse", "Kocak", "ayse.kocak", "ayse.kocak", "CHEF"),
//                new Employee(3, "Saif", "Alamrani", "saif.alamrani", "saif.alamrani", "RECEPTIONIST"),
//                new Employee(4, "Zeynel", "Goksu", "zeynel.goksu", "zeynel.goksu", "KITCHEN"),
//                new Employee(5, "Issa", "Rizqallah", "issa.rizqallah", "issa.rizqallah", "CASHIER"),
//                new Employee(6, "Ibrahim", "Sahin", "crazyboy007", "crazyboy007", "WAITER"),
//                new Employee(7, "Alex", "De Souza", "alex", "alex", "ADMIN")
//        ));
//        final List<Food> foodList = new ArrayList<>(Arrays.asList(
//                new Food(100, "Chicken Salad", "Meal", 9, "gr", 15),
//                new Food(101, "Salad", "Starter", 2.1, "gr", 5),
//                new Food(102, "Wonton Soup with BBQ", "Starter", 400, "ml", 4.99),
//                new Food(103, "Five Star", "meal", 800, "gr", 25),
//                new Food(104, "Chicken Kang ka Ree", "meal", 850, "gr", 35)));
//
//        final List<Guest> guestList = new ArrayList<>(Arrays.asList(
//                new Guest(1, "Mila", "Bom", 061234567, 234),
//                new Guest(2, "Alex", "De Souza", 061234567, 345),
//                new Guest(3, "Yolant", "Verbulen", 061234567, 456),
//                new Guest(4, "Johan", "Cruyff", 061234567, 567),
//                new Guest(5, "Pogba", "Henry", 061234567, 678),
//                new Guest(6, "Sedat", "Peker", 061234567, 789)
//        ));
//
//        final List<Table> tableList = new ArrayList<>(Arrays.asList(
//                new Table(1, 2, 2),
//                new Table(2, 4, 1),
//                new Table(3, 6, 2),
//                new Table(4, 8, 1),
//                new Table(5, 2, 2),
//                new Table(6, 2, 1),
//                new Table(7, 8, 1)
//        ));
//
//        final List<Menu> menuList = new ArrayList<>(Arrays.asList(
//                new Menu(1, "Pancake", "BREAKFAST", "Cake on the pan", 5),
//                new Menu(2, "Potato Salad", "SALAD", "SALAD", 2),
//                new Menu(3, "Green Pesto", "PASTA", "PASTA", 3),
//                new Menu(4, "Hickory Smoked Chicken", "Chicken", "ENTREES", 7),
//                new Menu(5, "Red Iced Tea", "Tea with Ice even Red", "BEVERAGES", 1)
//
//        ));
//        menuList.forEach(menu -> menuService.save(menu));
//        drinkService.saveAllDrink(drinkList);
//        employeeList.forEach(employee -> employeeService.createEmployee(employee));
//        foodService.saveAllFood(foodList);
//        guestService.saveAllGuest(guestList);
//        tableService.saveAllTable(tableList);
//    }
}