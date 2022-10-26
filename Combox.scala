
import java.awt._
import java.awt.event.{FocusAdapter, FocusEvent}
import java.awt.font.TextAttribute

import javax.swing._
import javax.swing.border._
import javax.swing.WindowConstants.EXIT_ON_CLOSE

import scala.jdk.CollectionConverters._

object Combox {
  def main(args: Array[String]): Unit = {
    createAndShowGUI()
  }
  def createAndShowGUI(): Unit = {
    val frame = new JFrame("Comb")
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
    val pane = new Combox()
    pane.setOpaque(true)
    frame.setContentPane(pane)
    frame.pack()
    frame.setVisible(true)
  }
  private val defaultFont = new Font("SimSun", Font.PLAIN, 12) //默认字体
  private val atts = Map[TextAttribute, Object](
    TextAttribute.FOREGROUND -> Color.RED,
    TextAttribute.STRIKETHROUGH -> TextAttribute.STRIKETHROUGH_ON
  ).asJava
  private val errorFont = Font.getFont(Combox.atts)
}

class Combox() extends JPanel {
  init()

  private var label1: JLabel= _
  private var label2: JLabel= _
  private var label3: JLabel= _
  private var label4: JLabel= _
  private var label5: JLabel= _
  private var label6: JLabel= _
  private var textField1: JTextField = _
  private var textField2: JTextField = _
  private var textField3: JTextField = _
  private var textField4: JTextField = _
  private var textField5: JTextField = _
  private var textField6: JTextField = _

  private var okButton: JButton = null


  private def changeFont(component: JComponent): Unit = {
    if (component.getInputVerifier.verify(component)) {
      component.setFont(Combox.defaultFont)
    } else {
      component.setFont(Combox.errorFont)
    }
  }

  private def createComboBox: JComboBox[String] = {
    val comb = new JComboBox(Array("B", "KB", "MB", "GB"))
    comb.setPreferredSize(new Dimension(50, 20))
    comb.setSelectedIndex(1)
    comb
  }

  private def init(): Unit = {
    val root = Box.createVerticalBox
    val bannerLabel = new JLabel("系统参数")
    root.add(bannerLabel)

    //-------------setTheInputPanel------------------------------
    val inputPanel = new JPanel
    val inputPanelBorder = new TitledBorder("设置参数")
    inputPanel.setPreferredSize(new Dimension(600, 400))
    inputPanelBorder.setTitleFont(Combox.defaultFont)
    inputPanel.setBorder(inputPanelBorder)
    val vtemp = Box.createVerticalBox
    val htemp1 = Box.createHorizontalBox
    val htemp2 = Box.createHorizontalBox
    val htemp3 = Box.createHorizontalBox
    val htemp4 = Box.createHorizontalBox
    val htemp5 = Box.createHorizontalBox
    val htemp6 = Box.createHorizontalBox

    label1 = new JLabel("address width:")
    label1.setPreferredSize(new Dimension(120, 20))
    textField1 = new JTextField()
    textField1.setPreferredSize(new Dimension(30, 20))
    textField1.setToolTipText("address width of system")
    val verifier1 = new InputVerifier {
      override def verify(input: JComponent): Boolean = input match {
        case i: JTextField =>
          val text = i.getText()
          val flag = (text.toInt > 1)
          if (flag) {
            input.setFont(Combox.defaultFont)
          } else {
            input.setFont(Combox.errorFont)
          }
          flag
        case _ => false
      }
    }
    textField1.setInputVerifier(verifier1)

    label2 = new JLabel("memory align:")
    label2.setPreferredSize(new Dimension(120, 20))
    textField2 = new JTextField()
    textField2.setMinimumSize(new Dimension(30, 20))
    textField2.setToolTipText("align of memory address in cluster")
    val unit1: JComboBox[String] = createComboBox

    label3 = new JLabel("device align:")
    label3.setPreferredSize(new Dimension(120, 20))
    textField3 = new JTextField()
    textField3.setPreferredSize(new Dimension(30, 20))
    textField3.setToolTipText("align of device address in cluster")
    val unit2: JComboBox[String] = createComboBox

    label4 = new JLabel("msgMem align:")
    label4.setPreferredSize(new Dimension(120, 20))
    textField4 = new JTextField()
    textField4.setPreferredSize(new Dimension(30, 20))
    textField4.setToolTipText("align of msgMem address in cluster")
    val unit3: JComboBox[String] = createComboBox

    label5 = new JLabel("memory coefficient:")
    label5.setPreferredSize(new Dimension(120, 20))
    textField5 = new JTextField()
    textField5.setPreferredSize(new Dimension(30, 20))
    textField5.setToolTipText("memory coefficient of memory address in all system")

    label6 = new JLabel("device factor:")
    label6.setPreferredSize(new Dimension(120, 20))
    textField6 = new JTextField()
    textField6.setPreferredSize(new Dimension(30, 20))
    textField6.setToolTipText("device factor of memory address in all system")

    okButton = new JButton("确认")

    htemp1.add(label1)
    htemp1.add(Box.createHorizontalStrut(10))
    htemp1.add(textField1)

    htemp2.add(label2)
    htemp2.add(Box.createHorizontalStrut(10))
    htemp2.add(textField2)
    htemp2.add(Box.createHorizontalStrut(10))
    htemp2.add(unit1)

    htemp3.add(label3)
    htemp3.add(Box.createHorizontalStrut(10))
    htemp3.add(textField3)
    htemp3.add(Box.createHorizontalStrut(10))
    htemp3.add(unit2)

    htemp4.add(label4)
    htemp4.add(Box.createHorizontalStrut(10))
    htemp4.add(textField4)
    htemp4.add(Box.createHorizontalStrut(10))
    htemp4.add(unit3)

    htemp5.add(label5)
    htemp5.add(Box.createHorizontalStrut(10))
    htemp5.add(textField5)

    htemp6.add(label6)
    htemp6.add(Box.createHorizontalStrut(10))
    htemp6.add(textField6)

    vtemp.add(htemp1)
    vtemp.add(Box.createVerticalStrut(10)) //创建上下空间距离
    vtemp.add(htemp2)
    vtemp.add(Box.createVerticalStrut(10))
    vtemp.add(htemp3)
    vtemp.add(Box.createVerticalStrut(10))
    vtemp.add(htemp4)
    vtemp.add(Box.createVerticalStrut(10))
    vtemp.add(htemp5)
    vtemp.add(Box.createVerticalStrut(10))
    vtemp.add(htemp6)
    vtemp.add(Box.createVerticalStrut(25))
    vtemp.add(Box.createVerticalStrut(5))
    inputPanel.add(vtemp)

    root.add(inputPanel)
    root.add(okButton)
    this.add(root, BorderLayout.NORTH)
  }


}