package cliente.controlador;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ControladorGraficos {
    
    private JPanel panelGraficos;
    
    public ControladorGraficos(JPanel panel){
        this.panelGraficos = panel;
    }
    
    private void actualizarGraficoBarras(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(votosProductoA, "Producto A", nombreProductoA);
        dataset.addValue(votosProductoB, "Producto B", nombreProductoB);
        dataset.addValue(votosProductoC, "Producto C", nombreProductoC);
        
        JFreeChart grafico = ChartFactory.createBarChart("", "Productos", "Votos", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel contenedorGraficoBarras;
        contenedorGraficoBarras = new ChartPanel(grafico);
        contenedorGraficoBarras.setSize(400, 300);
        contenedorGraficoBarras.setVisible(true);
        //contenedorGraficoBarras.updateUI();
        panelGraficos.add(contenedorGraficoBarras);
        contenedorGraficoBarras.updateUI();
        
    }
    
    private void actualizarGraficoPastel(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(nombreProductoA, votosProductoA);
        dataset.setValue(nombreProductoB, votosProductoB);
        dataset.setValue(nombreProductoC, votosProductoC);
        
        JFreeChart grafico = ChartFactory.createPieChart(" ", dataset, true, true, false);
        
        ChartPanel contenedorGraficoPastel;
        contenedorGraficoPastel = new ChartPanel(grafico);
        contenedorGraficoPastel.setSize(400, 300);
        contenedorGraficoPastel.setVisible(true);
        //contenedorGraficoPastel.updateUI();
        panelGraficos.add(contenedorGraficoPastel);
        contenedorGraficoPastel.updateUI();
    }
    
    public void actualizarGraficos(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        panelGraficos.removeAll();
        actualizarGraficoBarras(votosProductoA, nombreProductoA, votosProductoB, nombreProductoB, votosProductoC, nombreProductoC);
        actualizarGraficoPastel(votosProductoA, nombreProductoA, votosProductoB, nombreProductoB, votosProductoC, nombreProductoC);
        panelGraficos.setVisible(true);
        panelGraficos.updateUI();
    }   
    
    public JPanel getPanelGraficos(){
        return this.panelGraficos;
    }   
    
}
