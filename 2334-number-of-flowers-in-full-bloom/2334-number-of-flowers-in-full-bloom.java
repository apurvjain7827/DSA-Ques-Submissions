class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> flowerCount = new TreeMap<>();

        for (int[] flower : flowers) {
            flowerCount.put(flower[0], flowerCount.getOrDefault(flower[0], 0) + 1);
            flowerCount.put(flower[1] + 1, flowerCount.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int totalFlowers = 0;

        for (Map.Entry<Integer, Integer> entry : flowerCount.entrySet()) {
            int day = entry.getKey();
            int flowersDelta = entry.getValue();

            totalFlowers += flowersDelta;
            flowerCount.put(day, totalFlowers);
        }

        int[] answer = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int personTime = people[i];
            Integer floorKey = flowerCount.floorKey(personTime);
            answer[i] = (floorKey != null) ? flowerCount.get(floorKey) : 0;
        }

        return answer;
    }
}