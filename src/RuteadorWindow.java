import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Wed Sep 10 11:52:49 CST 2014
 */

/**
 * @author Werner
 */
public class RuteadorWindow extends JFrame {
    private final String hostAddress;
    JFileChooser fd = new JFileChooser();

    public void log(final String txt) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                txtLog.append(txt);
            }
        });
    }

    public RuteadorWindow(String hostAddress) {

        super();
        this.hostAddress = hostAddress;

        try {
                // set look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // set icon image
                Image image = ImageIO.read(ClassLoader.getSystemResource("router.png"));
                super.setIconImage(image);

                // register font
                Font font = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("terminal.TTF"));
                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);

            } catch (Exception ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }

        initComponents();

        lblSource.setText(hostAddress);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelMenu = new JPanel();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem2 = new JMenuItem();
        toolBar1 = new JToolBar();
        button2 = new JButton();
        btnTable = new JButton();
        panelStatus = new JPanel();
        lblStatus1 = new JLabel();
        lblStatus2 = new JLabel();
        panelMain = new JPanel();
        panelMsg = new JPanel();
        label3 = new JLabel();
        lblSource = new JLabel();
        label4 = new JLabel();
        txtTarget = new JTextField();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtMsg = new JTextArea();
        panel1 = new JPanel();
        btnSend = new JButton();
        splitPane1 = new JSplitPane();
        scrollPane2 = new JScrollPane();
        txtLog = new JTextArea();
        contentPanel = new JPanel();
        toolBar2 = new JToolBar();
        button3 = new JButton();
        button6 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button7 = new JButton();
        scrollPane3 = new JScrollPane();
        table1 = new JTable();
        actionSalir = new Salir();
        actionRouteTable = new ShowRouteTable();
        actionAbout = new About();
        actionStart = new Start();
        actionOpenRouteFile = new OpenRouteFile();
        actionInsertRoute = new InsertRoute();
        actionDelRoute = new EliminarRuta();
        actionSaveTable = new SaveTable();
        actionRefreshTable = new RefreshTable();
        actionSendMessage = new SendMessage();

        //======== this ========
        setVisible(true);
        setTitle("Proyecto 2 CC8 - Ruteador de Paquetes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(640, 480));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panelMenu ========
        {
            panelMenu.setBorder(null);
            panelMenu.setLayout(new GridLayout(2, 1));

            //======== menuBar1 ========
            {

                //======== menu1 ========
                {
                    menu1.setText("Archivo");
                    menu1.setMnemonic('A');

                    //---- menuItem1 ----
                    menuItem1.setMnemonic('S');
                    menuItem1.setAction(actionSalir);
                    menu1.add(menuItem1);
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText("Herramientas");
                    menu2.setMnemonic('H');

                    //---- menuItem4 ----
                    menuItem4.setText("text");
                    menuItem4.setAction(actionStart);
                    menu2.add(menuItem4);
                    menu2.addSeparator();

                    //---- menuItem3 ----
                    menuItem3.setAction(actionRouteTable);
                    menuItem3.setMnemonic('T');
                    menu2.add(menuItem3);
                }
                menuBar1.add(menu2);

                //======== menu3 ========
                {
                    menu3.setText("Ayuda");
                    menu3.setMnemonic('U');

                    //---- menuItem2 ----
                    menuItem2.setAction(actionAbout);
                    menu3.add(menuItem2);
                }
                menuBar1.add(menu3);
            }
            panelMenu.add(menuBar1);

            //======== toolBar1 ========
            {
                toolBar1.setFloatable(false);

                //---- button2 ----
                button2.setAction(actionStart);
                button2.setMnemonic('I');
                toolBar1.add(button2);

                //---- btnTable ----
                btnTable.setText("text");
                btnTable.setAction(actionRouteTable);
                btnTable.setMnemonic('T');
                btnTable.setSelected(true);
                toolBar1.add(btnTable);
            }
            panelMenu.add(toolBar1);
        }
        contentPane.add(panelMenu, BorderLayout.NORTH);

        //======== panelStatus ========
        {
            panelStatus.setBorder(new CompoundBorder(
                new SoftBevelBorder(SoftBevelBorder.LOWERED),
                new EmptyBorder(2, 2, 2, 2)));
            panelStatus.setLayout(new GridBagLayout());
            ((GridBagLayout)panelStatus.getLayout()).columnWidths = new int[] {170, 0, 0};
            ((GridBagLayout)panelStatus.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panelStatus.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)panelStatus.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- lblStatus1 ----
            lblStatus1.setText("Listo");
            panelStatus.add(lblStatus1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));
            panelStatus.add(lblStatus2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panelStatus, BorderLayout.SOUTH);

        //======== panelMain ========
        {
            panelMain.setBorder(new BevelBorder(BevelBorder.LOWERED));
            panelMain.setLayout(new BorderLayout(5, 5));

            //======== panelMsg ========
            {
                panelMsg.setBorder(new EmptyBorder(5, 5, 5, 5));
                panelMsg.setLayout(new GridBagLayout());
                ((GridBagLayout)panelMsg.getLayout()).columnWidths = new int[] {96, 0, 0};
                ((GridBagLayout)panelMsg.getLayout()).rowHeights = new int[] {0, 0, 64, 0, 0};
                ((GridBagLayout)panelMsg.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panelMsg.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- label3 ----
                label3.setText("Origen:");
                label3.setFont(new Font("Tahoma", Font.BOLD, 14));
                panelMsg.add(label3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lblSource ----
                lblSource.setText("localhost");
                lblSource.setFont(new Font("Tahoma", Font.BOLD, 14));
                panelMsg.add(lblSource, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label4 ----
                label4.setText("Destino:");
                label4.setFont(new Font("Tahoma", Font.BOLD, 14));
                label4.setDisplayedMnemonic('D');
                panelMsg.add(label4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- txtTarget ----
                txtTarget.setFont(new Font("Tahoma", Font.PLAIN, 14));
                txtTarget.setFocusAccelerator('D');
                panelMsg.add(txtTarget, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label5 ----
                label5.setText("Mensaje:");
                label5.setFont(new Font("Tahoma", Font.BOLD, 14));
                label5.setVerticalAlignment(SwingConstants.TOP);
                label5.setDisplayedMnemonic('M');
                panelMsg.add(label5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- txtMsg ----
                    txtMsg.setText("Mensaje de prueba");
                    txtMsg.setFocusAccelerator('M');
                    scrollPane1.setViewportView(txtMsg);
                }
                panelMsg.add(scrollPane1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

                    //---- btnSend ----
                    btnSend.setAction(actionSendMessage);
                    btnSend.setMnemonic('E');
                    panel1.add(btnSend);
                }
                panelMsg.add(panel1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panelMain.add(panelMsg, BorderLayout.PAGE_START);

            //======== splitPane1 ========
            {
                splitPane1.setDividerLocation(400);

                //======== scrollPane2 ========
                {

                    //---- txtLog ----
                    txtLog.setEditable(false);
                    txtLog.setBackground(Color.black);
                    txtLog.setForeground(Color.white);
                    txtLog.setLineWrap(true);
                    scrollPane2.setViewportView(txtLog);
                }
                splitPane1.setLeftComponent(scrollPane2);

                //======== contentPanel ========
                {
                    contentPanel.setLayout(new BorderLayout());

                    //======== toolBar2 ========
                    {
                        toolBar2.setFloatable(false);

                        //---- button3 ----
                        button3.setAction(actionOpenRouteFile);
                        toolBar2.add(button3);

                        //---- button6 ----
                        button6.setAction(actionSaveTable);
                        toolBar2.add(button6);
                        toolBar2.addSeparator();

                        //---- button4 ----
                        button4.setAction(actionInsertRoute);
                        toolBar2.add(button4);

                        //---- button5 ----
                        button5.setAction(actionDelRoute);
                        toolBar2.add(button5);
                        toolBar2.addSeparator();

                        //---- button7 ----
                        button7.setAction(actionRefreshTable);
                        toolBar2.add(button7);
                    }
                    contentPanel.add(toolBar2, BorderLayout.PAGE_START);

                    //======== scrollPane3 ========
                    {

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null},
                                {null, null, null, null},
                            },
                            new String[] {
                                "#", "Host", "IP", "DV"
                            }
                        ));
                        scrollPane3.setViewportView(table1);
                    }
                    contentPanel.add(scrollPane3, BorderLayout.CENTER);
                }
                splitPane1.setRightComponent(contentPanel);
            }
            panelMain.add(splitPane1, BorderLayout.CENTER);
        }
        contentPane.add(panelMain, BorderLayout.CENTER);
        setSize(635, 415);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panelMenu;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem2;
    private JToolBar toolBar1;
    private JButton button2;
    private JButton btnTable;
    private JPanel panelStatus;
    private JLabel lblStatus1;
    private JLabel lblStatus2;
    private JPanel panelMain;
    private JPanel panelMsg;
    private JLabel label3;
    private JLabel lblSource;
    private JLabel label4;
    private JTextField txtTarget;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextArea txtMsg;
    private JPanel panel1;
    private JButton btnSend;
    private JSplitPane splitPane1;
    private JScrollPane scrollPane2;
    private JTextArea txtLog;
    private JPanel contentPanel;
    private JToolBar toolBar2;
    private JButton button3;
    private JButton button6;
    private JButton button4;
    private JButton button5;
    private JButton button7;
    private JScrollPane scrollPane3;
    private JTable table1;
    private Salir actionSalir;
    private ShowRouteTable actionRouteTable;
    private About actionAbout;
    private Start actionStart;
    private OpenRouteFile actionOpenRouteFile;
    private InsertRoute actionInsertRoute;
    private EliminarRuta actionDelRoute;
    private SaveTable actionSaveTable;
    private RefreshTable actionRefreshTable;
    private SendMessage actionSendMessage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private class Salir extends AbstractAction {
        private Salir() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "Salir");
            putValue(SHORT_DESCRIPTION, "Salir el programa");
            putValue(LONG_DESCRIPTION, "Salir el programa");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
            putValue(ACTION_COMMAND_KEY, "Salir");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/exclamation.png")));
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class ShowRouteTable extends AbstractAction {
        private ShowRouteTable() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "Tabla de Ruteo");
            putValue(SHORT_DESCRIPTION, "Mostrar Tabla de Ruteo");
            putValue(LONG_DESCRIPTION, "Mostrar Tabla de Ruteo");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/table.png")));
            putValue(ACTION_COMMAND_KEY, "RouteTable");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            btnTable.setSelected(!btnTable.isSelected());
            contentPanel.setVisible(btnTable.isSelected());
            splitPane1.setDividerSize(contentPanel.isVisible()? 5 : 0);
            splitPane1.updateUI();
        }
    }

    private class About extends AbstractAction {
        private About() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "Acerca de...");
            putValue(SHORT_DESCRIPTION, "Acerca de...");
            putValue(LONG_DESCRIPTION, "Acerca de...");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/help.png")));
            putValue(ACTION_COMMAND_KEY, "About");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class Start extends AbstractAction {
        private Start() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "Iniciar");
            putValue(SHORT_DESCRIPTION, "Iniciar simulaci\u00f3n");
            putValue(LONG_DESCRIPTION, "Iniciar simulaci\u00f3n");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/resultset_next.png")));
            putValue(ACTION_COMMAND_KEY, "Start");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class OpenRouteFile extends AbstractAction {
        private OpenRouteFile() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(SHORT_DESCRIPTION, "Abrir archivo de rutas");
            putValue(LONG_DESCRIPTION, "Abrir archivo de rutas");
            putValue(ACTION_COMMAND_KEY, "OpenRouteFile");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/folder_table.png")));
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            if (fd.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            }
        }
    }

    private class InsertRoute extends AbstractAction {
        private InsertRoute() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(SHORT_DESCRIPTION, "Agregar Ruta");
            putValue(LONG_DESCRIPTION, "Agregar Ruta");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/table_row_insert.png")));
            putValue(ACTION_COMMAND_KEY, "AddRoute");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class EliminarRuta extends AbstractAction {
        private EliminarRuta() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(SHORT_DESCRIPTION, "Eliminar Ruta");
            putValue(LONG_DESCRIPTION, "Eliminar Ruta");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/table_row_delete.png")));
            putValue(ACTION_COMMAND_KEY, "DelRoute");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class SaveTable extends AbstractAction {
        private SaveTable() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(SHORT_DESCRIPTION, "Guardar Tabla");
            putValue(LONG_DESCRIPTION, "Guardar Tabla");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/table_save.png")));
            putValue(ACTION_COMMAND_KEY, "SaveTable");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class RefreshTable extends AbstractAction {
        private RefreshTable() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(SHORT_DESCRIPTION, "Actualizar Tabla");
            putValue(LONG_DESCRIPTION, "Actualizar Tabla");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/table_refresh.png")));
            putValue(ACTION_COMMAND_KEY, "RefreshTable");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }

    private class SendMessage extends AbstractAction {
        private SendMessage() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "Enviar mensaje");
            putValue(SHORT_DESCRIPTION, "Enviar mensaje");
            putValue(LONG_DESCRIPTION, "Enviar mensaje");
            putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/images/email_go.png")));
            putValue(ACTION_COMMAND_KEY, "SendMsg");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }
}
