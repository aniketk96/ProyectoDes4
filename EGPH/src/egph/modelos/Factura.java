package egph.modelos;

public class Factura {

	private int id_cajera;
	private String nombre_cajera;
	private String nombre_cliente;
	private String producto;
	private int cantidad;
	private float precio;
	
	public int getId_cajera() {
		return id_cajera;
	}
	public void setId_cajera(int id_cajera) {
		this.id_cajera = id_cajera;
	}
	public String getNombre_cajera() {
		return nombre_cajera;
	}
	public void setNombre_cajera(String nombre_cajera) {
		this.nombre_cajera = nombre_cajera;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
