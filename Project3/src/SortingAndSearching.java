//********************************************************************
//  SortingAndSearching.java    Authors: Lewis/Chase
//  modified by Bob  Wilson 10/28/2015
//  Demonstrates sorting and searching on an array of objects.
//********************************************************************

public class SortingAndSearching<T extends Comparable<T>>  
{
	private int compareCount;  
	private int memoryCount;
	private int memoryCount2;
	private int maxMemoryCount;
	private int maxMemoryCount2;

	public SortingAndSearching()
	{
		compareCount = 0;
		memoryCount = 0;
		memoryCount2 = 0;
		maxMemoryCount = 0;
		maxMemoryCount2 = 0;
	}

	public void resetCompareCount()
	{
		compareCount = 0;
	}

	public int getCompareCount()
	{
		return compareCount;
	}
   
	public int getMaxMemoryCount()
	{
		return maxMemoryCount;
	}
	
	public int getMaxMemoryCount2()
	{
		return maxMemoryCount2;
	}
	
	public int getMemoryCount()
	{
		return memoryCount;
	}
	
	public int getMemoryCount2()
	{
		return memoryCount2;
	}
	/********************************************************************
     Sorts the specified array of objects using the quick sort
     algorithm.
	 ********************************************************************/
	public void quickSort (T[] data, int min, int max)
	{
		int indexofpartition;

		if (max - min  > 0)
		{
			/** Create partitions */
			indexofpartition = findPartition(data, min, max);

			/** Sort the left side */
			quickSort(data, min, indexofpartition - 1);

			/** Sort the right side */
			quickSort(data, indexofpartition + 1, max);
		}
	}

	public void quickSort2(T[] data, int min, int max)
	{
		int indexofpartition;

		if (max - min  > 0)
		{
			/** Create partitions */
			indexofpartition = findPartition2(data, min, max);

			/** Sort the left side */
			quickSort2(data, min, indexofpartition - 1);

			/** Sort the right side */
			quickSort2(data, indexofpartition + 1, max);
		}
	}
	/********************************************************************
     	Used by the quick sort algorithm to find the partition.
	 ********************************************************************/
	private int findPartition (T[] data, int min, int max)
	{
		int left, right;
		T temp, partitionelement;

		partitionelement = data[min]; // use first element as partition
		left = min;
		right = max;
   
		
		while (left<right)
		{
			/** search for an element that is > the partitionelement */
			compareCount++;
			while (data[left].compareTo(partitionelement) <=0 &&
					left < right){
				left++;
				compareCount++;
			}

			/** search for an element that is < the partitionelement */
			compareCount++;
			while (data[right].compareTo(partitionelement) > 0){
				right--;
				compareCount++;
			}

			/** swap the elements  */
			if (left<right)
			{
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}

		/** move partition element to partition index*/
		temp = data[min];
		data[min] = data[right];
		data[right] = temp;
         
		return right;
	}
	
	private int findPartition2 (T[] data, int min, int max)
	{
		int left, right;
		T temp, partitionelement;
		int middle = (min + max) / 2;

		partitionelement = data[middle]; // use middle element as partition
		left = min;
		right = max;
		
		// swape the middle and first element
		temp = data[min];
		data[min] = data[middle];
		data[middle] = temp;
		
		while (left<right)
		{
			/** search for an element that is > the partitionelement */
			compareCount++;
			while (data[left].compareTo(partitionelement) <=0 &&
					left < right){
				left++;
				compareCount++;
			}

			/** search for an element that is < the partitionelement */
			compareCount++;
			while (data[right].compareTo(partitionelement) > 0){
				right--;
				compareCount++;
			}

			/** swap the elements  */
			if (left<right)
			{
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}

		/** move partition element to partition index*/
		temp = data[min];
		data[min] = data[right];
		data[right] = temp;
         
		return right;
	}

	/********************************************************************
     Sorts the specified array of objects using the merge sort
     algorithm.
	 ********************************************************************/
	@SuppressWarnings("unchecked")
	public void mergeSort (T[] data, int min, int max)
	{
		T[] temp;
		int index1, left, right;

		/** return on list of length one */
		if (min == max)
			return; 

		/** find the length and the midpoint of the list */
		int size = max - min + 1;
		int pivot = (min + max) / 2;
		temp = (T[])(new Comparable[size]);

		memoryCount += size;
//		System.out.println("maxMemoryCount: "+ maxMemoryCount + ";  memoryCount: " + memoryCount);
		mergeSort(data, min, pivot); // sort left half of list
		mergeSort(data, pivot + 1, max); // sort right half of list

		/** copy sorted data into workspace */
		for (index1 = 0; index1 < size; index1++)
			temp[index1] = data[min + index1];
      
		/** merge the two sorted lists */
		left = 0;
		right = pivot - min + 1;
		for (index1 = 0; index1 < size; index1++)
		{
			if (right <= max - min){
				if (left <= pivot - min){
					compareCount++;
					if (temp[left].compareTo(temp[right]) > 0){
						data[index1 + min] = temp[right++];
					}
					else{
						data[index1 + min] = temp[left++];
					}
				}
				else{
					data[index1 + min] = temp[right++];
				}
			}
			else{
				data[index1 + min] = temp[left++];
			}
		}
//		System.out.println("memoryCount: " + memoryCount + ";  size: " + size + "; maxMemoryCount: " + maxMemoryCount);
		if(maxMemoryCount < memoryCount)
			maxMemoryCount = memoryCount;
		memoryCount -= size;
	}

	@SuppressWarnings("unchecked")
	public void mergeSort2 (T[] data, int min, int max)
	{
		T[] temp;
		int index1, left, right;

		/** return on list of length one */
		if (min == max)
			return; 

		/** find the length and the midpoint of the list */
		int size = max - min + 1;
		int pivot = (min + max) / 2;
      
		mergeSort2(data, min, pivot); // sort left half of list
		mergeSort2(data, pivot + 1, max); // sort right half of list

		temp = (T[])(new Comparable[size]);  
		memoryCount2 += size;
		
		/** copy sorted data into workspace */
		for (index1 = 0; index1 < size; index1++)
			temp[index1] = data[min + index1];
      
		/** merge the two sorted lists */
		left = 0;
		right = pivot - min + 1;
		for (index1 = 0; index1 < size; index1++)
		{
			if (right <= max - min){
				if (left <= pivot - min){
					compareCount++;
					if (temp[left].compareTo(temp[right]) > 0){
						data[index1 + min] = temp[right++];
					}
					else{
						data[index1 + min] = temp[left++];
					}
				}
				else{
					data[index1 + min] = temp[right++];
				}
			}
			else{
				data[index1 + min] = temp[left++];
			}
		}
//		System.out.print(memoryCount2 + " ");
		if(maxMemoryCount2 < memoryCount2)
			maxMemoryCount2 = memoryCount2;
		memoryCount2 -= size;
	}

	/********************************************************************
     	Sorts the specified array of objects using a bubble sort
     algorithm.
	 ********************************************************************/
	public void bubbleSort (T[] data)
	{
		int position, scan;
		T temp;
		
		for (position =  data.length - 1; position >= 0; position--)
		{
			for (scan = 0; scan <= position - 1; scan++)
			{
				compareCount++;
				if (data[scan].compareTo(data[scan+1]) > 0)
				{
					/** Swap the values */
					temp = data[scan];
					data[scan] = data[scan + 1];
					data[scan + 1] = temp;
				}
			}
		}
	}
	
	public void bubbleSort2 (T[] data)
	{
		int position, scan;
		T temp;
		
		for (position = data.length - 1; position >= 0; position--)
		{
			boolean finishSort = true;
			for (scan = 0; scan <= position - 1; scan++)
			{
				compareCount++;
				if (data[scan].compareTo(data[scan+1]) > 0)
				{
					/** Swap the values */
					temp = data[scan];
					data[scan] = data[scan + 1];
					data[scan + 1] = temp;
					finishSort = false;
				}
			}
			if (finishSort){
				break;
			}
		}
	}

	/********************************************************************
     Searches the specified array of objects using a linear search
     algorithm.
	 ********************************************************************/
	public boolean linearSearch (T[] data,int min, int max, T target)
	{
		int index = min;
		boolean found = false;

		while (!found && index <= max) 
		{
			if (data[index].compareTo(target) == 0) 
				found = true;
			index++;
		}

		return found;
	}

	/********************************************************************
     Searches the specified array of objects using a binary search
     	algorithm.
	 ********************************************************************/
	public boolean binarySearch (T[] data, int min, int max, T target)
	{  
		boolean found = false;
		int midpoint = (min + max) / 2;  // determine the midpoint

		if (data[midpoint].compareTo(target) == 0)
			found = true;

		else if (data[midpoint].compareTo(target) > 0)
		{
			if (min <= midpoint - 1)
				found = binarySearch(data, min, midpoint - 1, target);
		}
      
		else if (midpoint + 1 <= max)
			found = binarySearch(data, midpoint + 1, max, target);

		return found;
	}

	/********************************************************************
     Sorts the specified array of integers using the selection
     	sort algorithm.
	 ********************************************************************/
	public void selectionSort (T[] data)
	{
		int min;
		T temp;
		
		for (int index = 0; index < data.length-1; index++)
		{
			min = index;
			for (int scan = index+1; scan < data.length; scan++){
				compareCount++;
				if (data[scan].compareTo(data[min]) < 0){
					min = scan;
				}
			}
			/** Swap the values */
			temp = data[min];
			data[min] = data[index];
			data[index] = temp;
		}
	}
	/********************************************************************
     Sorts the specified array of objects using an insertion
     	sort algorithm.
	 ********************************************************************/
	public void insertionSort (T[] data)
	{
		for (int index = 1; index < data.length; index++)
		{
			T key = data[index];
			int position = index;

			/** Shift larger values to the right */
			compareCount++;
			while (position > 0 && data[position-1].compareTo(key) > 0)
			{
				
				data[position] = data[position-1];
				position--;
				compareCount++;
			}
            
			data[position] = key;
		}
	}
}  /*201540*/
