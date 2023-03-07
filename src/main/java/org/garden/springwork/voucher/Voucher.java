package org.garden.springwork.voucher;

import java.util.UUID;

public interface Voucher {
    UUID getVoucherId();
    long discount(long beforeDiscount);
}
//discount 행위
//하나의 Entity가 될거임