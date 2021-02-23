package br.com.tag.sdk.service.reicevable.position;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.position.PositionExpectationQueryResponse;
import br.com.tag.sdk.model.receivable.position.PositionQueryFilter;
import br.com.tag.sdk.model.receivable.position.PositionReceivablesQueryResponse;
import br.com.tag.sdk.service.IService;

public interface IPositionService extends IService {

    PositionReceivablesQueryResponse getPositionsWithKey(String key) throws TagSDKException;
    PositionReceivablesQueryResponse getPositionsWithReference(String reference) throws TagSDKException;
    PositionReceivablesQueryResponse getPositionsWithProcessReference(String processReference) throws TagSDKException;
    PositionReceivablesQueryResponse getPositionsWithOriginalAssetHolder(String originalAssetHolder, PositionQueryFilter paramsObj) throws TagSDKException;
    PositionExpectationQueryResponse getPositionsWithAssetHolder(String assetHolder, PositionQueryFilter paramsObj) throws TagSDKException;

}
