import javax.swing.JOptionPane

    //------------------------------------------------------------------

    fun main(args: Array<String>) {
        var str: List<String> = JOptionPane.showInputDialog("ادخل الجملة من فضلك: ")!!.split(" ")      // USER INPUT
        val algr: Array<String> = arrayOf("من", "الى", "عن", "في", "على", "مذ", "منذ")
        val alatf: Array<String> = arrayOf("ثم", "حتى", "ام", "او", "بل", "لا", "لاكن")
        var out = ArrayList<String>()

        //------------------------------------------------------------------
        for (i in 0..str.size - 1) {

            var x: String = str[i]

            //----------------------------------------------------------------
            var length: Int = x.length
            var v: String = ""
            var last: String = ""
            var second: String = ""
            var f2: String = ""
            var fourth: String = ""
            //-----------------------------------------------------------------

            try {
                v = x[0].toString()
            }                 // first char
            catch (ex: Exception) {
            }
            try {
                last = x[length - 2] + x[length - 1].toString()
            } // last two char
            catch (ex: Exception) {
            }
            try {
                second = x[1].toString()
            }            // second char
            catch (ex: Exception) {
            }
            try {
                f2 = x[0] + x[1].toString()
            }              // first two chars
            catch (ex: Exception) {
            }
            try {
                fourth = x[3].toString()
            }          // fourth char
            catch (ex: Exception) {
            }
            //-----------------------------------------------------------------
            //    HROF ALATF
            if (x in alatf) {
                out.add(x + ": حرف عطف")
            }

            //  ----------------------------------------------------------------
            if (v.equals("و")) {
                out.add("و: حرف عطف")
            }

            if (x in algr) {
                out.add(x + ": حرف جر")
            }                                                    //    HROF ALGAR
            //--------------------------------------------------------------------
            if (f2.equals("ال") && x != "الى") {                       // AL ESM ALMO3ARAF B AL
                out.add(x + ": اسم معرف ب ال")
            }
            //  ------------------------------------------ALFE3L ALMODARE3
            if (v.equals("ي") || v.equals("ت")) {
                out.add(x + ": فعل مضارع")
            }
            //-----------------------------------------ALMOTHANA
            if (last.equals("ان") || last.equals("ين")) {
                out.add(x + ": مثنى")
            }
            //--------------------------------------------GAM3 ALMOZAKR ALSALEM
            if (last.equals("ون")) {
                out.add(x + ": جمع مذكر سالم")
            }

            //  --------------------------------------------GAM3 MOANATH SALEM
            if (last.equals("ات")) {
                out.add(x + ": جمع مؤنث سالم")
            }
            if (x[0].equals("f")) {
            }
// -------------------------------------------------ESM ALFA3L
            if (second.equals("ا") && length == 4) {
                out.add(x + ": اسم فاعل")
            }
            if (v.equals("م") && fourth.equals("و") && length == 5) {
                out.add(x + ": اسم مفعول")
            }
            if (x.endsWith("ة")&&last!="ات") {
                out.add(x + ": اسم مؤنث")

            }



//---------------------------------------------------------------

        }

        JOptionPane.showMessageDialog(null, "$out")
//

    }
