package seminarie2;

import java.util.ArrayList;
import java.util.List;

public class phone {
    interface Call {
        // ...
    }

    interface Money {
        // ...
    }

    interface PayPlan {
        Money debit(Call call);
        // ...
    }

    class CashCardPlan implements PayPlan {
        public Money debit(Call call) {
            // ...
        };
    }

    class KnockOutPlan implements PayPlan {
        public Money debit(Call call) {
            // ...
        };
    }

    class TotalCost {
        public Money totalCost(List<Call> calls, PayPlan pp) {
            // ... beräkna totalkostnad för alla samtal ...
        }
    }

    class PhonePlan {

        private String phoneNumber;
        protected List<Call> calls = new ArrayList<>();

        public PhonePlan() {
        }

        public Money TotalCost() {
            return new TotalCost().totalCost(calls, plan);
        }

        public Money debit (PayPlan plan){
            return plan.debit();
        }

        // ... övriga metoder ...

    }

    new PhonePlan(new PayPlan())
}
