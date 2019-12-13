package main.adapter;

import main.entities.AttrItems;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"属性(Attrs)", "值(Values)"};
    private AttrItems[] list = new AttrItems[]{
            new AttrItems("app:shape","形状:[RECTANGLE|OVAL|LINE|RING]",""),
            new AttrItems("app:color","主色:[color]",""),
            new AttrItems("app:pressColor","按压颜色:[color]",""),
            new AttrItems("app:focusColor","聚焦颜色:[color]",""),
            new AttrItems("app:rippleColor","水波纹颜色:[color]",""),
            new AttrItems("app:radius","圆角:[dimension]",""),
            new AttrItems("app:strokeColor","描边颜色:[color]",""),
            new AttrItems("app:strokeWidth","描边宽度:[dimension]",""),
            new AttrItems("app:dashGap","虚线间隙宽度:[dimension]",""),
            new AttrItems("app:dashWidth","虚线主体宽度[dimension]:",""),
            new AttrItems("app:gradient","渐变:[LINEAR|RADIAL|SWEEP]",""),
            new AttrItems("app:orientation","渐变方向:[TOP_BOTTOM|TR_BL等]",""),
            new AttrItems("app:startColor","三色渐变起始颜色:[color]",""),
            new AttrItems("app:centerColor","三色渐变中间颜色:[color]",""),
            new AttrItems("app:endColor","三色渐变终止颜色:[color]",""),
            new AttrItems("app:gradientRadius","渐变半径[dimension]",""),
            new AttrItems("app:islock","渐变时锁定底部图层:[boolean]",""),
    };

    @Override
    public int getRowCount() {
        return list.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o;
        switch (columnIndex) {
            case 0: {
                o = list[rowIndex].name +"        "+ list[rowIndex].intro;
                break;
            }
            case 1: {
                o = list[rowIndex].value;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + columnIndex);
        }
        return o;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                list[rowIndex].value = (String) aValue;
                break;
            default:
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public AttrItems[] getList() {
        return list;
    }
}
