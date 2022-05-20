package test;
public class Test {
    public static long[] getData(){
         long[] data = {1646674769434L, 6655, 1646674771182l, 6742, 1646674771913l, 6704, 1646674773782l, 7000, 1646674775333l, 6693, 1646674776703l, 6913};
         return data;
    }
    public static Double getAverage(long[] data){
        double avg = 0;
        int x=0;
        for(int i=1; i<data.length; i+=2){
            avg+=Double.parseDouble(String.valueOf(data[i]));
            x++;
        }
        return avg/x;
    }
    public static Double getModus(long[] data){
        double time = 0;
        for(int i = 0; i<data.length; i+=2){
            time = data[i];
        }
        return time;
    }
    public static long getMin(long[] data){
        long sampel = 99999999;
        long t;
        long min = 0;
        for(int i = 1; i<data.length; i+=2){
            t = data[i];
            if(t < sampel){
                sampel = t;
                min = sampel;
            }
        }
        return min;
    }
    
    public static long getMax(long[] data){
        long sampel = -99999999;
        long t;
        long max = 0;
        for(int i = 1; i<data.length; i+=2){
            t = data[i];
            if(t > sampel){
                sampel = t;
                max = sampel;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        long[] data = getData();
        double avg = getAverage(data);
        System.out.println(avg);
        double modus = getModus(data);
        System.out.println(modus);
        long min = getMin(data);
        System.out.println(min);
        long max = getMax(data);
        System.out.println(max);
    }
}
