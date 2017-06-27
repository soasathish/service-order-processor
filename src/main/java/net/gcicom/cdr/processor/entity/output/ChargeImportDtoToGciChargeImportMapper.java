package net.gcicom.cdr.processor.entity.output;


import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.gcicom.cdr.processor.entity.input.ChargeImportDto;


@Component
public class ChargeImportDtoToGciChargeImportMapper {
			
	
		Logger logger = LoggerFactory.getLogger(ChargeImportDtoToGciChargeImportMapper.class);

	
		public List<GCIChargeImport> convertToGCIChargeImport(final List<ChargeImportDto> input) {
			
			List<GCIChargeImport> cdrs = new ArrayList<>();

			for (ChargeImportDto source : input) {
				
				logger.debug("Converting ChargeImportDto to GCIChargeImport" + source.toString());

				GCIChargeImport cdr = new GCIChargeImport();
				CDRKey id = new CDRKey(source.getOriginatingNumber(), 
							source.getOriginatingNumber(), 
							source.getDialedNumber() ); 
							//Timestamp.valueOf(source.getDate().atTime(LocalTime.parse(source.getTime(), DateTimeFormatter.ISO_LOCAL_TIME))));
				cdr.setId(id);
				cdr.setDuration(source.getDuration());
				cdr.setSupplierId(source.getSupplier());
				cdr.setLastModifiedBy("SYSTEM");
				logger.debug("Converted cdr " + cdr.toString());
				cdrs.add(cdr);
			}
			
			

			return cdrs;
			
		}
	
	
}
