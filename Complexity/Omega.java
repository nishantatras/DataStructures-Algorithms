import javax.swing.plaf.synth.SynthStyleFactory;

public class Omega{
public static void main(String[] args) {

// int sum=0;
// int n=3;
// for(int i=1; i<n; i++){
//     for(; i<n*n; i++){
//     sum+=i;
// }
// }
// System.out.println(sum);
//if i=2, loop enters n^2 loop and exits n loop,cause i will always be greater than n when leaves n^2 loop
//>>>O(n^2) & not O(n^3)

int n=100,noo=0;
for(int i=1; i<n; i*=2){
noo++;
}
System.out.println(noo);
}
}