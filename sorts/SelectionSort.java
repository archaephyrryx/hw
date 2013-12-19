import java.util.ArrayList;

public Class SelectionSort {
    public void SelectionSort( int[] data ) {
	for (int i = 0; i < data.length; ++i) {
	    int min = data[i];
	    for (int j = 0; (j + i) < data.length; ++j) {
		min = (data[i+j] > min) ? data[i+j] : min;
	    }
	    data[i] 
		


}
