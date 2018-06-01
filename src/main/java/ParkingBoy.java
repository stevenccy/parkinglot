import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> packLots;

    public ParkingBoy(List<ParkingLot> packLots){
        this.packLots = packLots;
    }
    
    public ParkingLot findBestPackingLot(){
    	ParkingLot bestPl = null;
    	for(ParkingLot pl : packLots){
    		if(bestPl == null ){
    			bestPl = pl;
    			continue;
    		}
    		bestPl = (pl.getRemainSpace() > bestPl.getRemainSpace()) ?  pl: bestPl;
    	}
    	return bestPl;
    }

    public ParkingLot findBestParkingLotWithPersentage(){
		ParkingLot bestPl = null;
		for(ParkingLot pl : packLots){
			if(bestPl == null ){
				bestPl = pl;
				continue;
			}
			bestPl = (pl.getRemainPersentage() > bestPl.getRemainPersentage()) ?  pl: bestPl;
		}
		return bestPl;

	}

  
}