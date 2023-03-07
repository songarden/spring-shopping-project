package org.garden.springwork.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    
    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(()->new RuntimeException(MessageFormat.format("can not found a voucher for {0}", voucherId)));
    }

    public void useVoucher(Voucher voucher) {
    }
}
