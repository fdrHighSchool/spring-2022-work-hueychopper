public class ClassFRQ {
    class StepTracker {
        private int minsteps;
        private int gstep = 0;
        private int activeDay = 0;
        private int cstep;
        private int days = 0;

        public StepTracker(int stepsDay) {
            this.minsteps = stepsDay;
        } 
        public void addDailySteps(int steps) {
            this.gstep += steps;
            this.days++;
            this.cstep = steps;
            if(this.cstep >= this.minsteps) {
                this.activeDay += 1;
            }
        }
        public int activeDays() {
            return this.activeDay;
        }
        public double averageSteps() {
            if(this.gstep != 0 && this.days != 0) {
                return (double)this.gstep / (double)this.days;
            }
            return 0.0;
        }
    }
    public static void main(String[] args) {
        ClassFRQ vn = new ClassFRQ();
        ClassFRQ.StepTracker tr = vn.new StepTracker(10000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(13000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(23000);
        tr.addDailySteps(1111);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
    }
}