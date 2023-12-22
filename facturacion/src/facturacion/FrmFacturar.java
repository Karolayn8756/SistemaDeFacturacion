package facturacion;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;


public class FrmFacturar extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblCedula;
	private JLabel lblNombres;
	private JLabel lblTelfono;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblDireccin;
	private JTable table;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private DefaultTableModel model;
	private JLabel lblIVA;
	private JLabel lblSubtotal;


	public FrmFacturar() {
		getContentPane().setBackground(new Color(128, 128, 192));
		setTitle("Factura");
		setBounds(100, 100, 853, 586);
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setIcon(new ImageIcon(FrmFacturar.class.getResource("/facturacion/icon/icon6.png")));
		lblCliente.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblCliente.setBounds(23, 72, 158, 48);
		getContentPane().add(lblCliente);
		
		JButton btnSeleccionarCliente = new JButton("Seleccionar cliente");
		btnSeleccionarCliente.setFont(new Font("Sitka Text", Font.BOLD, 10));
		btnSeleccionarCliente.setBackground(new Color(255, 128, 192));
		btnSeleccionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedirDatos();
			}
		});
		btnSeleccionarCliente.setBounds(446, 142, 145, 28);
		getContentPane().add(btnSeleccionarCliente);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblCedula.setBounds(23, 143, 242, 27);
		getContentPane().add(lblCedula);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNombres.setBounds(23, 180, 242, 27);
		getContentPane().add(lblNombres);
		
		lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblTelfono.setBounds(240, 180, 242, 27);
		getContentPane().add(lblTelfono);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblApellidos.setBounds(23, 217, 242, 27);
		getContentPane().add(lblApellidos);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblEmail.setBounds(240, 216, 242, 27);
		getContentPane().add(lblEmail);
		
		lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblDireccin.setBounds(240, 143, 242, 27);
		getContentPane().add(lblDireccin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmFacturar.class.getResource("/facturacion/icon/icon7 (2).png")));
		btnCancelar.setBackground(new Color(255, 128, 192));
		btnCancelar.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(145, 3, 133, 48);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 274, 582, 273);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 128, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod", "Detalle", "Precio", "Cantidad", "Total"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setIcon(new ImageIcon(FrmFacturar.class.getResource("/facturacion/icon/icon10.png")));
		btnEliminarProducto.setBackground(new Color(255, 128, 192));
		btnEliminarProducto.setFont(new Font("Sitka Text", Font.BOLD, 10));
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
			}
		});
		btnEliminarProducto.setBounds(655, 74, 176, 46);
		getContentPane().add(btnEliminarProducto);
		
		JButton btnAgregarProductos = new JButton("Agregar Producto");
		btnAgregarProductos.setIcon(new ImageIcon(FrmFacturar.class.getResource("/facturacion/icon/icon11.png")));
		btnAgregarProductos.setBackground(new Color(255, 128, 192));
		btnAgregarProductos.setFont(new Font("Sitka Text", Font.BOLD, 10));
		btnAgregarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		btnAgregarProductos.setBounds(655, 26, 176, 38);
		getContentPane().add(btnAgregarProductos);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmFacturar.class.getResource("/facturacion/icon/icon8 (1).png")));
		btnNuevo.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNuevo.setBackground(new Color(255, 128, 192));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirDeNuevo();
			}
		});
		btnNuevo.setBounds(10, 3, 125, 48);
		getContentPane().add(btnNuevo);

	}
	private void pedirDatos() {
		FrmListaCliente listaCliente = new FrmListaCliente(new JDialog(), true, lblCedula, lblNombres, lblApellidos, lblTelfono, lblEmail, lblDireccin);
		listaCliente.setVisible(true);
	}
	
	private void agregarProducto() {
		ListaProductos listaProductos = new ListaProductos(new JDialog(), true, this.model, this.productos, lblApellidos, lblApellidos, lblApellidos);
		listaProductos.setVisible(true);
	}
	
	private void eliminarProducto() {
		EliminarProducto eliminarProducto = new EliminarProducto(new JDialog(), true, this.model, this.productos, lblApellidos, lblApellidos, lblApellidos);
		eliminarProducto.setVisible(true);
	}
	private void abrirDeNuevo() {
		Container menuPrincipal = this.getParent();
		this.dispose();
		FrmFacturar frmFacturar = new FrmFacturar();
		frmFacturar.setVisible(true);
		menuPrincipal.add(frmFacturar);
	}
}
