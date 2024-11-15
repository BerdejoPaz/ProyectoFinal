
import java.util.ArrayList;
import java.util.Scanner;

// Clase principal del sistema
public class Programa02 {
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Menú del Sistema ---");
            System.out.println("1. Ingresar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Ingresar Cliente");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Realizar Venta");
            System.out.println("6. Mostrar Ventas Realizadas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer
            
            switch (opcion) {
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    ingresarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    realizarVenta();
                    break;
                case 6:
                    mostrarVentas();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    // Método para ingresar productos
    public static void ingresarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        
        productos.add(new Producto(nombre, precio, stock));
        System.out.println("Producto agregado exitosamente.");
    }

    // Método para mostrar productos
    public static void mostrarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            producto.mostrarProducto();
        }
    }

    // Método para ingresar clientes
    public static void ingresarCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();
        
        clientes.add(new Cliente(nombre, cedula));
        System.out.println("Cliente agregado exitosamente.");
    }

    // Método para mostrar clientes
    public static void mostrarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
    }

    // Método para realizar una venta
    public static void realizarVenta() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.nombre.equals(nombreCliente)) {
                cliente = c;
                break;
            }
        }
        
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        
        Producto producto = null;
        for (Producto p : productos) {
            if (p.nombre.equals(nombreProducto)) {
                producto = p;
                break;
            }
        }
        
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidad = scanner.nextInt();
        
        if (cantidad > producto.stock) {
            System.out.println("No hay suficiente stock.");
        } else {
            producto.stock -= cantidad;
            Venta venta = new Venta(cliente, producto, cantidad);
            ventas.add(venta);
            System.out.println("Venta realizada exitosamente.");
        }
    }

    // Método para mostrar las ventas realizadas
    public static void mostrarVentas() {
        System.out.println("\n--- Ventas Realizadas ---");
        for (Venta venta : ventas) {
            venta.mostrarVenta();
        }
    }
}
