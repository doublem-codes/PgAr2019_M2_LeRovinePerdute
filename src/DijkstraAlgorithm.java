import java.util.ArrayList;

public class DijkstraAlgorithm {

    private int[] distance;
    private int[] nodeFrom;
    ArrayList<Integer> visitedNodes = new ArrayList<>();
    ArrayList<Integer> nearNodes = new ArrayList<>();
/*
    private boolean dijkstraAlgorithm(ArrayList<City> cities) {


        public int[] getDistance () {
            return distance;
        }

        public DijkstraAlgorithm(ArrayList < Integer > visitedNodes) {
            this.visitedNodes = visitedNodes;
        }

        public void setDistance ( int[] distance){
            this.distance = distance;
        }

        public int[] getNodeFrom () {
            return nodeFrom;
        }

        public void setNodeFrom ( int[] nodeFrom){
            this.nodeFrom = nodeFrom;
        }

        private boolean dijkstraAlgorithm () {
            maxDistance(distance);
            return true;
        }

        private void maxDistance ( int[] distance){
            if (distance != null) {
                distance[0] = 0;
                for (int i = 0; i < distance.length; i++) {
                    distance[i] = Integer.MAX_VALUE;
                }
            }

        }


        private int partition ( int[] a, int low, int hi)
        {
            int pivot = hi;
            int i = low;
            int j = hi - 1;
            while (i < j) {
                if (a[i] <= a[pivot]) {
                    i++;
                }
                if (a[i] > a[pivot]) {
                    if ((a[i] > a[pivot]) && (a[j] <= a[pivot])) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i++;
                    }
                    if (a[j] > a[pivot]) {
                        j--;
                    }
                }
            }
            int temp = a[i];
            a[i] = a[pivot];
            a[pivot] = temp;
            return i;
        }
        private void quicksort ( int[] a, int low, int hi)
        {
            if (low >= hi) {
                return;
            }
            int split = partition(a, low, hi);
            quicksort(a, low, split - 1);
            quicksort(a, split + 1, hi);
        }

        private void calculateDistance (ArrayList < City > arrayListCities) {

            for (int i = 0; i < arrayListCities.size(); i++) {
                int coordinateXFirstElements = arrayListCities.get(i).getCoordinate().getX();
                int coordinateXSecondElements;
                int coordinateYFirstElements = arrayListCities.get(i).getCoordinate().getY();
                int coordinateYSecondElements;
                int coordinateHFirstElements = arrayListCities.get(i).getCoordinate().getH();
                int coordinateHSecondElements;

                ArrayList arrayListCities.get(i).getArrayListCityConnect();


            }
        }

 */
    }

